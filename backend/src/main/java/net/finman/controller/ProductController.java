package net.finman.controller;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.exception.ResourceNotUpdatedException;
import net.finman.model.Item;
import net.finman.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Item i) throws ResourceNotCreatedException {
        productService.createProduct(i);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/products/{owner}")
    public ResponseEntity<?> getProductsOwnedBy(@PathVariable String owner) throws ResourceNotFoundException {
        return new ResponseEntity<>(productService.getProductsOwnedBy(owner), HttpStatus.FOUND);
    }

    @DeleteMapping("/products/{owner}/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String owner, @PathVariable String name)
            throws ResourceNotFoundException, ResourceNotDeletedException {
        productService.deleteProduct(owner, name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/products/{owner}/{name}")
    public ResponseEntity<?> updateProduct(@PathVariable String owner, @PathVariable String name, @RequestBody Item item)
            throws ResourceNotFoundException, ResourceNotUpdatedException {
        productService.updateProduct(owner, name, item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
