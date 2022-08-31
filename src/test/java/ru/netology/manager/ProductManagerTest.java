package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Война и мир", 250, "Лев Толстой");
    Product book2 = new Book(2, "Отцы и дети", 340, "Иван Тургенев");
    Product book3 = new Book(3, "Собачье сердце", 190, "Михаил Булгаков");
    Product smartphone1 = new Smartphone(4, "iPhone 11", 75_000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy S 10", 34_000, "Samsung");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldFindFirstBookName() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSecondBookName() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Отцы и дети");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindThirdBookName() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Собачье сердце");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFirstSmartphoneName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("iPhone 11");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSecondSmartphoneName() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Galaxy S 10");

        Assertions.assertArrayEquals(expected, actual);
    }

}



