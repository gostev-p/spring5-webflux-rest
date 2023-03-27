package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0) {
            //load data
            System.out.println("#### LOADING DATA ON BOOTSTRAP #####");
            loadCategoryData();
            loadVendorData();
        }
    }

    private void loadCategoryData() {
            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());
    }

    private void loadVendorData() {
            vendorRepository.save(Vendor.builder()
                    .firstname("Joe")
                    .lastname("Buck").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Micheal")
                    .lastname("Weston").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Jessie")
                    .lastname("Waters").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Bill")
                    .lastname("Nershi").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstname("Jimmy")
                    .lastname("Buffett").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
    }
}
