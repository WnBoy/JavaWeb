package com.xupt.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-03-31 13:03
 */
public class Cart {

    //    private Integer totalCount;//总数量
//    private BigDecimal totalPrice;//总价格
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 删除商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，
        // 如果没有添加过，直接放到集合中即可
        CartItem item = items.get(cartItem.getId());
        if (item != null) {//如果之前加过
            item.setCount(item.getCount() + 1);//增加这个购物项的数量
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新购物项的总金额
        } else {//如果之前没有加过
            items.put(cartItem.getId(), cartItem);
        }
    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     */
    public void updateCount(Integer id, Integer count) {
        // 先查看购物车中是否有此商品。如果有，修改商品数量，更新总金额
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);//修改数量
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新购物项的总金额
        }
    }

    /**
     * 购物车商品总数量
     * @return
     */
    public Integer getTotalCount() {
        Integer integer = items.values().stream().map((e) -> e.getCount()).reduce(0, Integer::sum);
        return integer;
    }

    /**
     * 购物车商品总金额
     * @return
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
