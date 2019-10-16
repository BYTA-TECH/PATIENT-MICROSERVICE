package com.bytatech.ayoos.web.rest;
import com.bytatech.ayoos.service.DMSRecordService;
import com.bytatech.ayoos.web.rest.errors.BadRequestAlertException;
import com.bytatech.ayoos.web.rest.util.HeaderUtil;
import com.bytatech.ayoos.web.rest.util.PaginationUtil;
import com.bytatech.ayoos.service.dto.DMSRecordDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing DMSRecord.
 */
@RestController
@RequestMapping("/api")
public class DMSRecordResource {

    private final Logger log = LoggerFactory.getLogger(DMSRecordResource.class);

    private static final String ENTITY_NAME = "patientServiceDmsRecord";

    private final DMSRecordService dMSRecordService;

    public DMSRecordResource(DMSRecordService dMSRecordService) {
        this.dMSRecordService = dMSRecordService;
    }

    /**
     * POST  /dms-records : Create a new dMSRecord.
     *
     * @param dMSRecordDTO the dMSRecordDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dMSRecordDTO, or with status 400 (Bad Request) if the dMSRecord has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/dms-records")
    public ResponseEntity<DMSRecordDTO> createDMSRecord(@RequestBody DMSRecordDTO dMSRecordDTO) throws URISyntaxException {
        log.debug("REST request to save DMSRecord : {}", dMSRecordDTO);
        if (dMSRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new dMSRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DMSRecordDTO result = dMSRecordService.save(dMSRecordDTO);
        return ResponseEntity.created(new URI("/api/dms-records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /dms-records : Updates an existing dMSRecord.
     *
     * @param dMSRecordDTO the dMSRecordDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dMSRecordDTO,
     * or with status 400 (Bad Request) if the dMSRecordDTO is not valid,
     * or with status 500 (Internal Server Error) if the dMSRecordDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/dms-records")
    public ResponseEntity<DMSRecordDTO> updateDMSRecord(@RequestBody DMSRecordDTO dMSRecordDTO) throws URISyntaxException {
        log.debug("REST request to update DMSRecord : {}", dMSRecordDTO);
        if (dMSRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DMSRecordDTO result = dMSRecordService.save(dMSRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dMSRecordDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /dms-records : get all the dMSRecords.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dMSRecords in body
     */
    @GetMapping("/dms-records")
    public ResponseEntity<List<DMSRecordDTO>> getAllDMSRecords(Pageable pageable) {
        log.debug("REST request to get a page of DMSRecords");
        Page<DMSRecordDTO> page = dMSRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/dms-records");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /dms-records/:id : get the "id" dMSRecord.
     *
     * @param id the id of the dMSRecordDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dMSRecordDTO, or with status 404 (Not Found)
     */
    @GetMapping("/dms-records/{id}")
    public ResponseEntity<DMSRecordDTO> getDMSRecord(@PathVariable Long id) {
        log.debug("REST request to get DMSRecord : {}", id);
        Optional<DMSRecordDTO> dMSRecordDTO = dMSRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dMSRecordDTO);
    }

    /**
     * DELETE  /dms-records/:id : delete the "id" dMSRecord.
     *
     * @param id the id of the dMSRecordDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/dms-records/{id}")
    public ResponseEntity<Void> deleteDMSRecord(@PathVariable Long id) {
        log.debug("REST request to delete DMSRecord : {}", id);
        dMSRecordService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/dms-records?query=:query : search for the dMSRecord corresponding
     * to the query.
     *
     * @param query the query of the dMSRecord search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/dms-records")
    public ResponseEntity<List<DMSRecordDTO>> searchDMSRecords(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of DMSRecords for query {}", query);
        Page<DMSRecordDTO> page = dMSRecordService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/dms-records");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
