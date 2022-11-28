package com.hmc.client;

import com.hmc.common.dto.response.RedditDTO;
import com.hmc.common.dto.response.RedditGroupDTO;
import com.hmc.common.dto.response.Response;
import com.hmc.config.FeignClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@LoadBalancerClient(name = "social")
@FeignClient(name = "social", url = "localhost:9090/social",
        fallbackFactory = SocialClientFallback.class, configuration = FeignClientConfiguration.class)
public interface SocialClient {

    @GetMapping("/api/reddit-group/{id}/detail")
    Response<RedditGroupDTO> getRedditGroupById(@PathVariable("id") String id);

    @GetMapping("/api/reddit/user-owner")
    Response<RedditDTO> getRedditByOwner();

}
