package com.project.productservice.models;

public class ProductWithDetails {
	
	
	private Product product;
    private ProductDetail productDetail;

    public ProductWithDetails(Product product, ProductDetail productDetail) {
        this.product = product;
        this.productDetail = productDetail;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetail getProductDetails() {
        return productDetail;
    }

    public void setProductDetails(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
	
}
