package com.bytatech.ayoos.repository.search;

import com.bytatech.ayoos.domain.DMSRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the DMSRecord entity.
 */
public interface DMSRecordSearchRepository extends ElasticsearchRepository<DMSRecord, Long> {
}
