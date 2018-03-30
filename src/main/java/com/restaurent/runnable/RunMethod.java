package com.restaurent.runnable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restaurent.entity.CategoryDetails;
import com.restaurent.entity.ProductDetails;
import com.restaurent.entity.UserCartDetails;
import com.restaurent.entity.UserDetails;
import com.restaurent.entity.UserOrderDetails;
import com.restaurent.repository.CategoryRepository;
import com.restaurent.repository.ProductRepository;
import com.restaurent.repository.UserCartRepository;
import com.restaurent.repository.UserOrderRepository;
import com.restaurent.repository.UserRepository;

@Component
public class RunMethod implements CommandLineRunner  {

	@Autowired
    CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserCartRepository userCartRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOrderRepository userOrderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
/*		
			CategoryDetails cc = new CategoryDetails("Punjabi","Veg",null,null,"A");
			System.out.println("comes here");
			categoryRepository.save(cc);
			
			ProductDetails pp =new ProductDetails("PaneerMasala","Punjabi Cusine",110,null,null,"A");
			pp.setCategorydetails(cc);
			productRepository.save(pp);
			
			ProductDetails pp2 =new ProductDetails("PaneerButterMasala","Punjabi Cusine",110,null,null,"A");
			pp2.setCategorydetails(cc);
			productRepository.save(pp2);
			
			ProductDetails pp1 =new ProductDetails("PaneerMasala","Punjabi Cusine",110,null,null,"A");
			pp1.setCategorydetails(cc);
			productRepository.save(pp1);
			
			UserDetails userDetails = new UserDetails("Nitin","Soman","nisoman23@gmail.com","99999","12@123","A",null,null);
			userRepository.save(userDetails);
			
			
			UserCartDetails userCart = new UserCartDetails(2,(float) 22.0,null,"A");
			userCart.setProductDetails(pp);
			userCart.setCategoryDetails(cc);
			userCart.setUserDetails(userDetails);
			userCartRepo.save(userCart);

			
			UserOrderDetails userOrder = new UserOrderDetails(2,(float) 22.0,null,"Cash On Delivery","Delivered","A");
			userOrder.setProductDetails(pp);
			userOrder.setCategoryDetails(cc);
			userOrder.setUserDetails(userDetails);
			userOrderRepository.save(userOrder);*/
		
	}


}
