package com.marquezv.dev.vendeLogo.dto.request;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marquezv.dev.vendeLogo.entities.ProductEntity;
import com.marquezv.dev.vendeLogo.entities.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequestDTO {

	private String productName;
	
	private Long price;
	
	private Integer amount;
	
	private Long discount;
	
	private Timestamp published_date;
	
	private Integer status;

	private Long store_Id;
	
	private String store_Name;
	
	@JsonIgnore
	private StoreEntity storeEntity;
	
	public ProductEntity build() {
		ProductEntity product = new ProductEntity()
				.setProductName(this.productName)
				.setPrice(this.price)
				.setAmount(this.amount)
				.setDiscount(this.discount)
				.setPublished_date(this.published_date)
				.setStatus(this.status)
				.setStoreEntity(this.storeEntity);
		return product;
	}
	
	public ProductRequestDTO toDTO(ProductEntity productEntity) {
		ProductRequestDTO product = new ProductRequestDTO()
				.setProductName(productEntity.getProductName())
				.setPrice(productEntity.getPrice())
				.setDiscount(productEntity.getDiscount())
				.setPublished_date(productEntity.getPublished_date())
				.setStatus(productEntity.getStatus())
				.setStore_Id(productEntity.getStoreEntity().getId())
				.setStore_Name(productEntity.getStoreEntity().getStoreName());
		
		return product;
	}
}
