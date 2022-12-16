package com.hmc.client;

import com.hmc.common.dto.response.*;
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

    @GetMapping("/api/line/owner")
    Response<LineDTO> getLineByOwner();

    @GetMapping("/api/line/{id}/detail")
    Response<LineDTO> getLineById(@PathVariable("id") String id);

    @GetMapping("/api/reddit/{id}/detail")
    Response<RedditDTO> getRedditById(@PathVariable("id") String id);

    @GetMapping("/api/twitter/{id}/detail")
    Response<TwitterDTO> getTwitterById(@PathVariable("id") String id);

}
