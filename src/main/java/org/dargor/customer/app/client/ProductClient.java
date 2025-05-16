package org.dargor.customer.app.client;

import java.util.List;

import org.dargor.customer.app.client.config.FeignAuthInterceptor;
import org.dargor.customer.app.dto.request.WishListRequestDto;
import org.dargor.customer.app.dto.response.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ProductClient",
        url = "${routing.product-ms.host}:${routing.product-ms.port}/${routing.product-ms.url}",
        configuration = {FeignAuthInterceptor.class}
)
public interface ProductClient {

    @GetMapping("/${routing.product-ms.wishlist-url}/{customerId}")
    List<ProductResponseDto> getWishList(@PathVariable String customerId);

    @PostMapping("/${routing.product-ms.create-url}")
    List<ProductResponseDto> createProducts(@RequestBody WishListRequestDto products);

}
