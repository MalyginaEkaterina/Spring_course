package geekbrains.spring.lesson9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<ProductDto> getById(Integer id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Page<ProductDto> getAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).map(ProductDto::new);
    }

    public List<Product> getAllSorted(SortDirection sortCost, SortDirection sortTitle, Boolean costFirst) {
        Sort sortByCost = null;
        Sort sortByTitle = null;
        if (sortCost != null) {
            if (sortCost == SortDirection.ASC) {
                sortByCost = Sort.by("cost");
            } else {
                sortByCost = Sort.by("cost").descending();
            }
        }

        if (sortTitle != null) {
            if (sortTitle == SortDirection.ASC) {
                sortByTitle = Sort.by("title");
            } else {
                sortByTitle = Sort.by("title").descending();
            }
        }

        if (sortByCost == null) {
            return productRepository.findAll(sortByTitle);
        } else if (sortByTitle == null) {
            return productRepository.findAll(sortByCost);
        } else {
            if (costFirst) {
                return productRepository.findAll(sortByCost.and(sortByTitle));
            } else {
                return productRepository.findAll(sortByTitle.and(sortByCost));
            }
        }
    }

    public ProductDto addOrUpdate(ProductDto productDto) {
        return new ProductDto(productRepository.save(new Product(productDto)));
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllByMinCost(Double minCost) {
        return productRepository.findByCostGreaterThan(minCost);
    }

    public List<Product> getAllByMaxCost(Double maxCost) {
        return productRepository.findByCostLessThan(maxCost);
    }

    public List<Product> getAllByMinAndMaxCost(Double minCost, Double maxCost) {
        return productRepository.findByCostBetween(minCost, maxCost);
    }

    public List<Product> getAllByTitle(String title) {
        return productRepository.findByTitleIgnoreCaseContaining(title);
    }
}
