package com.marquezv.dev.vendeLogo.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Entity
@Table(name = "PRODUCT")
@ToString
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "PRICE")
	private Long price;
	
	@Column(name = "AMOUNT")
	private Integer amount;
	
	@Column(name = "DISCOUNT")
	private Long discount;
	
	@Column(name = "PUBLISHED_DATE")
	private Timestamp published_date;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "STORE_ID")
	private StoreEntity storeEntity;

}
