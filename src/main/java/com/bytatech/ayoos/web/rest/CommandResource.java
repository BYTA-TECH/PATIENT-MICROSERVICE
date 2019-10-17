package com.bytatech.ayoos.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.ayoos.client.custom_dms_core.ApiKeyRequestInterceptor;
import  com.bytatech.ayoos.client.custom_dms_core.api.SitesApi;
import com.bytatech.ayoos.client.auth_dms.api.AuthenticationApi;
import com.bytatech.ayoos.client.auth_dms.model.Ticket;
import com.bytatech.ayoos.client.auth_dms.model.TicketBody;
import com.bytatech.ayoos.client.auth_dms.model.TicketEntry;
import com.bytatech.ayoos.client.dms_core.api.PeopleApi;
//import com.bytatech.ayoos.client.dms_core.api.SitesApi;
import com.bytatech.ayoos.client.dms_core.model.PersonBodyCreate;
import com.bytatech.ayoos.client.dms_core.model.PersonEntry;
import com.bytatech.ayoos.client.dms_core.model.SiteBodyCreate.VisibilityEnum;
import com.bytatech.ayoos.client.dms_core.model.SiteEntry;
import com.bytatech.ayoos.client.dms_core.model.SiteMemberEntry;
import com.bytatech.ayoos.client.dms_core.model.SiteMembershipBodyCreate;
import com.bytatech.ayoos.client.dms_core.model.SiteMembershipBodyCreate.RoleEnum;
import com.bytatech.ayoos.client.dms_core.model.SiteBodyCreate;
/*import com.bytatech.ayoos.client.dms.api.SitesApi;
import com.bytatech.ayoos.client.dms.api.PeopleApi;
//import com.bytatech.ayoos.client.core_dms.model;
import com.bytatech.ayoos.client.dms.model.PersonBodyCreate;
import com.bytatech.ayoos.client.dms.model.SiteBodyCreate;
import com.bytatech.ayoos.client.dms.model.SiteBodyCreate.VisibilityEnum;
import com.bytatech.ayoos.client.dms.model.SiteEntry;
import com.bytatech.ayoos.client.dms.model.SiteMemberEntry;
import com.bytatech.ayoos.client.dms.model.SiteMembershipBodyCreate;
import com.bytatech.ayoos.client.dms.model.SiteMembershipBodyCreate.RoleEnum;*/
/*import com.bytatech.ayoos.client.custom_core_dms.ApiKeyRequestInterceptor;
import com.bytatech.ayoos.client.custom_core_dms.api.NodesApi;
import com.bytatech.ayoos.client.custom_core_dms.model.NodeBodyCreate;*/
import com.bytatech.ayoos.service.*;

import com.bytatech.ayoos.service.dto.PatientDTO;
import com.bytatech.ayoos.web.rest.errors.BadRequestAlertException;
import com.bytatech.ayoos.web.rest.util.HeaderUtil;

import feign.Feign;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

@RestController
@RequestMapping("/api/commands")

public class CommandResource {

	private final Logger log = LoggerFactory.getLogger(CommandResource.class);

	private static final String ENTITY_NAME = "Patient";
	@Autowired
	ApiKeyRequestInterceptor apiKeyRequestInterceptor;

	/*PeopleApi peopleApi;
	
	*/@Autowired
	AuthenticationApi authenticationApi;
	/*@Autowired
	NodesApi nodesApi;
	*/
	private  String ticket;
	private Decoder decoder;

	private Encoder encoder;
	
	@Autowired
	private  PatientService patientService;
	/*@Autowired
	SitesApi siteApi;*/
	@Autowired
	PeopleApi peopleApi;
	@Autowired
	SitesApi customSiteApi;
	@Autowired
	com.bytatech.ayoos.client.dms_core.api.SitesApi siteApi;
	@Autowired
	com.bytatech.ayoos.client.custom_dms_core.api.NodesApi nodesApi;

	/**
	 * POST /patients : Create a new patient.
	 *
	 * @param patientDTO
	 *            the patientDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         patientDTO, or with status 400 (Bad Request) if the patient has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */

	@PostMapping("/patients")
	public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) throws URISyntaxException {
		log.debug("REST request to save Patient : {}", patientDTO);
		if (patientDTO.getId() != null) {
			throw new BadRequestAlertException("A new patient cannot already have an ID", ENTITY_NAME, "idexists");
		}
		createPersonOnDMS(patientDTO);

		String siteId = patientDTO.getIdpCode() + "site";

		String dmsId = createSite(siteId);
		patientDTO.setDmsId(dmsId);
		createSiteMembership(dmsId, patientDTO.getIdpCode());
		PatientDTO result = patientService.save(patientDTO);

		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);
	}
	
	public void createPersonOnDMS(PatientDTO patientDTO) {
		log.debug("=================into the process createPeople()===========");
System.out.println("#################################"+patientDTO.getIdpCode());
		PersonBodyCreate personBodyCreate = new PersonBodyCreate();
		personBodyCreate.setId(patientDTO.getIdpCode());
		personBodyCreate.setFirstName(patientDTO.getIdpCode());
	personBodyCreate.setEmail(patientDTO.getIdpCode()+"@gmail.com");
		personBodyCreate.setPassword(patientDTO.getIdpCode());
		personBodyCreate.setEnabled(true);
		ResponseEntity<PersonEntry> p=peopleApi.createPerson(personBodyCreate, null);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+p.getBody());
	}

	/**
	 * Create a new patientDMS-Site.
	 *
	 * @param siteId
	 *            the patientDMS-Site to create
	 *
	 */


	public String createSite(String siteId) {
		SiteBodyCreate siteBodyCreate = new SiteBodyCreate();
		siteBodyCreate.setTitle(siteId);
		siteBodyCreate.setId(siteId);
		siteBodyCreate.setVisibility(VisibilityEnum.MODERATED);
		ResponseEntity<SiteEntry> entry = siteApi.createSite(siteBodyCreate, false, false, new ArrayList());
		return entry.getBody().getEntry().getId();
	}

	public SiteMemberEntry createSiteMembership(String siteId, String id) {
		SiteMembershipBodyCreate siteMembershipBodyCreate = new SiteMembershipBodyCreate();
		siteMembershipBodyCreate.setRole(RoleEnum.SITEMANAGER);
		siteMembershipBodyCreate.setId(id);
		return siteApi.createSiteMembership(siteId, siteMembershipBodyCreate, null).getBody();
	}

	//@GetMapping("createTicket/{userId}/{password}")
	public String testcreateTicket(/*@PathVariable*/ String userId,/*@PathVariable */String password) {
		
			TicketBody ticketBody = new TicketBody();
			ticketBody.setUserId(userId);
			ticketBody.setPassword(password);
			String tic=authenticationApi.createTicket(ticketBody).getBody().getEntry().getId();
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+tic);

			return tic;
		}
	@GetMapping("create/{siteId}")
	public String createSite2(@PathVariable String siteId) {
		com.bytatech.ayoos.client.custom_dms_core.model.SiteBodyCreate siteBodyCreate = new com.bytatech.ayoos.client.custom_dms_core.model.SiteBodyCreate();
		siteBodyCreate.setTitle(siteId);
		siteBodyCreate.setId(siteId);
		siteBodyCreate.setVisibility(com.bytatech.ayoos.client.custom_dms_core.model.SiteBodyCreate.VisibilityEnum.MODERATED);
		ResponseEntity<SiteEntry> entry = customSiteApi.createSite(siteBodyCreate, false, false, new ArrayList());
		return entry.getBody().getEntry().getId();
	}
	
	//@GetMapping("createTicket/{userId}/{password}")
	/*public void createTicket(@PathVariable String userId,@PathVariable String password) {
	//	testPerson();
		TicketBody ticketBody = new TicketBody();
		ticketBody.setUserId("ajay");
		ticketBody.setPassword("ajay");
		String tic=authenticationApi.createTicket(ticketBody).getBody().getEntry().getId();
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@"+tic);
		
		commandService.setTicket(tic);
		 //createNodes("testcustomfolder","ajaysite");
	}

*/	@PostMapping("/createNode/{nodeId}")
	public String createNodes(@PathVariable String nodeId/*@RequestBody NodeBodyCreate nodeBodyCreateString name,*//*String dmsId */) {
	//createPeople();
	String tic=testcreateTicket("sr23","sr23");
	apiKeyRequestInterceptor.setTicket(tic);
	System.out.println("+++++++++++++success++++++++++");
			  com.bytatech.ayoos.client.custom_dms_core.model.NodeBodyCreate nodeBodyCreate = new com.bytatech.ayoos.client.custom_dms_core.model.NodeBodyCreate();
				nodeBodyCreate.setName("soorajNayanth");
				nodeBodyCreate.setNodeType("cm:content");
				//nodeBodyCreate.setRelativePath("Sites/"+dmsId);

			//	NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();
				nodesApi.createNode("-my-", nodeBodyCreate, true, null, null);
			  
			 return "succes";
			  
			  }
	
	
	/*PostMapping("/createContent/{nodeId}")
	public String createContent(@PathVariable String nodeId, @RequestBody Resource body) {
		System.out.println("+++++++++++++success++++++++++" + body);
		nodesApi.updateNodeContent(nodeId, body, true, null, null, null, null);
		// nodesApi.updateNode(nodeId, nodeBodyUpdate, null, null);
		return "succes";
	}*/
	@GetMapping("/test1")
	public String test() {
		return "success";
		}
	
	
	
	//@PostMapping("/createPeople")
	public String createPeople(/*@RequestBody PersonBodyCreate personBodyCreate*/) {
		System.out.println("+++++++++++++Method Started++++++++++");
		
			PersonBodyCreate personBodyCreate = new PersonBodyCreate();
		personBodyCreate.setId("sr234");
		personBodyCreate.setFirstName("sr234");
	    personBodyCreate.setEmail("sr234"+"@gmail.com");
		personBodyCreate.setPassword("sr234");
		personBodyCreate.setEnabled(true);
		ResponseEntity<PersonEntry> p=peopleApi.createPerson(personBodyCreate, null);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+p.getBody());
		System.out.println(peopleApi.createPerson(personBodyCreate, null));
		System.out.println("+++++++++++++Method Ended++++++++++");
		return "succes";
	}
	
	
	
	

}
