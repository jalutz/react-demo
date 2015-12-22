package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.Cart;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.crypto.Data;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @Test
    public void testGetCartShouldReturnOne() throws Exception {
        Cart cart = cartService.getCart(3);
        Assert.assertNotNull(cart);
    }

    @Test
    public void testGetCartShouldReturnNull() throws Exception {
        Cart cart = cartService.getCart(0);
        Assert.assertNull(cart);
    }

    @Test
    public void testAddCartIdShouldNotBe0() throws Exception {
        Cart added = cartService.addCart(2);
        Assert.assertTrue(added.getCartId() > 0);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddCartShouldThrowError() throws Exception {
        //add cart with customer id that is not in table
        exception.expect(DataIntegrityViolationException.class);
        Cart added = cartService.addCart(0);
    }
}