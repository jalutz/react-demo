package com.services;

import com.StoreDemoIntellijApplication;
import com.classes.CartDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jlutz on 12/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StoreDemoIntellijApplication.class)
public class CartDetailServiceImplTest {

    @Autowired
    private CartDetailService cartDetailService;

    @Test
    public void testGetCartItemsShouldReturnOneOrMoreItems() throws Exception {
        List<CartDetail> cartDetailList = cartDetailService.getCartItems(1);
        Assert.assertTrue(cartDetailList.size() > 0);
    }

    @Test
    public void testGetCartItemsShouldReturnNoItems() throws Exception {
        List<CartDetail> cartDetailList = cartDetailService.getCartItems(0);
        Assert.assertTrue(cartDetailList.size() == 0);
    }

    @Test
    public void testGetCartItemShouldReturnItem() throws Exception {
        CartDetail cartDetail = cartDetailService.getCartItem(1, 7);
        Assert.assertNotNull(cartDetail);
    }

    @Test
    public void testGetCartItemShouldReturnNull() throws Exception {
        //give cartid of 0, should never return object
        CartDetail cartDetail = cartDetailService.getCartItem(0, 7);
        Assert.assertNull(cartDetail);
    }

    @Test
    public void testAddCartItem() throws Exception {

    }

    @Test
    public void testRemoveCartItem() throws Exception {

    }
}