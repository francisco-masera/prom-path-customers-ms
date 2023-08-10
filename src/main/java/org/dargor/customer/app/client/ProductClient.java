package org.dargor.customer.app.client;

import org.dargor.customer.app.client.config.FeignAuthInterceptor;
import org.dargor.customer.app.dto.WishListRequestDto;
import org.dargor.customer.app.dto.WishListResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "ProductClient",
        url = "${routing.product-ms.host}:${routing.product-ms.port}/${routing.product-ms.id}/${routing.product-ms.url}",
        configuration = {FeignAuthInterceptor.class}
)
public interface ProductClient {

    @GetMapping("/${routing.product-ms.wishlist-url}/{customerId}")
    WishListResponseDto getWishList(@PathVariable UUID customerId);

    @PostMapping("/${routing.product-ms.create-url}")
    WishListResponseDto createProducts(@RequestBody WishListRequestDto products);

}
