package service;

import model.Product;

public interface IProductService extends IService<Product> {
    void update(Product product);
}
