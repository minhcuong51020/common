package com.hmc.client;

import com.hmc.common.dto.response.*;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SocialClientFallback implements FallbackFactory<SocialClient> {

    @Override
    public SocialClient create(Throwable cause) {
        return new FallbackWithFactory(cause);
    }

    static class FallbackWithFactory implements SocialClient {
        private final Throwable cause;

        FallbackWithFactory(Throwable cause) {
            this.cause = cause;
        }

        @Override
        public Response<RedditGroupDTO> getRedditGroupById(String id) {
            return Response.fail(new RuntimeException());
        }

        @Override
        public Response<RedditDTO> getRedditByOwner() {
            return Response.fail(new RuntimeException());
        }

        @Override
        public Response<LineDTO> getLineByOwner() {
            return Response.fail(new RuntimeException());
        }

        @Override
        public Response<LineDTO> getLineById(String id) {
            return Response.fail(new RuntimeException());
        }

        @Override
        public Response<RedditDTO> getRedditById(String id) {
            return Response.fail(new RuntimeException());
        }

        @Override
        public Response<TwitterDTO> getTwitterById(String id) {
            return Response.fail(new RuntimeException());
        }
    }
}
