package com.marquezv.dev.vendeLogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marquezv.dev.vendeLogo.commons.status.StatusProduct;
import com.marquezv.dev.vendeLogo.dto.request.ProductRequestDTO;
import com.marquezv.dev.vendeLogo.entities.ProductEntity;
import com.marquezv.dev.vendeLogo.entities.StoreEntity;
import com.marquezv.dev.vendeLogo.repository.ProductRepository;
import com.marquezv.dev.vendeLogo.service.exceptions.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	StoreService storeService;
	
	public ProductRequestDTO findById(Long id) {
		ProductEntity productEntity = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("[SERVICE_ERROR] ID_NOT_FOUND [ " + id + " ]"));
		
		ProductRequestDTO productDTO = new ProductRequestDTO().toDTO(productEntity);
		return productDTO;
	}

	public List<ProductRequestDTO> findAll() {
		List<ProductRequestDTO> productRequestList = new ArrayList<ProductRequestDTO>();
		for(ProductEntity productEntity : repository.findAll()) {
			ProductRequestDTO productRequest = new ProductRequestDTO()
					.toDTO(productEntity);
			productRequestList.add(productRequest);
		}	
		
		return productRequestList;
	}
	
	public void save(ProductRequestDTO productDTO) {
		StoreEntity storeEntity = storeService.findByIdEntity(productDTO.getStore_Id()).orElseThrow(
				() -> new EntityNotFoundException("[SERVICE_ERROR] ID_NOT_FOUND [ " + productDTO.getStore_Id() + " ]"));
		
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		productDTO.setPublished_date(timestamp);
		productDTO.setStatus(StatusProduct.IN_STOCK.ordinal());
		productDTO.setAmount(1);
		productDTO.setStoreEntity(storeEntity);
		System.out.println(productDTO);
		repository.save(productDTO.build());
	}
	
}
