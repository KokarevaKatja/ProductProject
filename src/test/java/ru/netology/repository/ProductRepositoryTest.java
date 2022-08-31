package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Война и мир", 250, "Лев Толстой");
    Product book2 = new Book(2, "Отцы и дети", 340, "Иван Тургенев");
    Product book3 = new Book(3, "Собачье сердце", 190, "Михаил Булгаков");
    Product smartphone1 = new Smartphone(4, "iPhone 11", 75_000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy S 10", 34_000, "Samsung");

    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(book2.getId());

        Product[] expected = {book1, book3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

}