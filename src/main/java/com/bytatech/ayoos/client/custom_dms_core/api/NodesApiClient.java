package com.bytatech.ayoos.client.custom_dms_core.api;

import org.springframework.cloud.openfeign.FeignClient;
//import com.bytatech.ayoos.client.custom_dms_core.ClientConfiguration;

@FeignClient(name="${customDmsCore.name:customDmsCore}", url="${customDmsCore.url:https://i0rezn.trial.alfresco.com/alfresco/api/-default-/public/alfresco/versions/1}"/*, configuration = ClientConfiguration.class*/)
public interface NodesApiClient extends NodesApi {
}