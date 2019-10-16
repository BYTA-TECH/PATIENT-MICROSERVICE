package com.bytatech.ayoos.repository.search;

import com.bytatech.ayoos.domain.MedicalCase;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the MedicalCase entity.
 */
public interface MedicalCaseSearchRepository extends ElasticsearchRepository<MedicalCase, Long> {
}
