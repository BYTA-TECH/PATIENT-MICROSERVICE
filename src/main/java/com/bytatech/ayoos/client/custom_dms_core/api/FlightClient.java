package com.bytatech.ayoos.client.custom_dms_core.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytatech.ayoos.client.custom_dms_core.model.PersonPaging;
import com.bytatech.ayoos.client.custom_dms_core.model.SiteBodyCreate;
import com.bytatech.ayoos.client.custom_dms_core.model.SiteEntry;
import com.bytatech.ayoos.client.custom_dms_core.model.SitePaging;

import feign.Headers;
import io.swagger.annotations.ApiParam;

@FeignClient(name="FlightClient", url= "https://i0rezn.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1")
public interface FlightClient {
 /*@RequestMapping(method = RequestMethod.GET, value = "/flight/FRA/departure")
    List<FlightWrapper> getDepartingFlights();
    
    
 
 
 
 
    @RequestMapping(method = RequestMethod.GET, value = "/flightDetails/{airlineCode}/{flightNumber}/")
    List<FlightWrapper> getFlightDetails(@PathVariable("airlineCode") String airlineCode, @PathVariable("flightNumber") Integer flightNumber);
 */
    
    @RequestMapping(method = RequestMethod.GET, value = "/sites", produces = "application/json")
    ResponseEntity<SitePaging> listSites();
    
    
    
    @RequestMapping(value = "/people",
            produces = "application/json", 
            method = RequestMethod.GET)
   
    ResponseEntity<PersonPaging> listPeople(@RequestHeader("Authorization") String token);
    
    
    @RequestMapping(value = "/sites",
            produces = "application/json", 
            consumes = "application/json",
            method = RequestMethod.POST)
    ResponseEntity<SiteEntry> createSite(@ApiParam(value = "The site details" ,required=true )  @Valid @RequestBody SiteBodyCreate siteBodyCreate,@ApiParam(value = "Flag to indicate whether the Share-specific (surf) configuration files for the site should not be created.", defaultValue = "false") @Valid @RequestParam(value = "skipConfiguration", required = false, defaultValue="false") Boolean skipConfiguration,@ApiParam(value = "Flag to indicate whether the site should not be added to the user's site favorites.", defaultValue = "false") @Valid @RequestParam(value = "skipAddToFavorites", required = false, defaultValue="false") Boolean skipAddToFavorites,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

    
    
   /* @RequestMapping(value = "/people",
            produces = "application/json", 
            method = RequestMethod.GET)
   
    ResponseEntity<PersonPaging> listPeople();
    */
    
    
    

}
