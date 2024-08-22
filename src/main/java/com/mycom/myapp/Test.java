package com.mycom.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.mycom.myapp.config.MyPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

// JPQL
// insert (X), select, update, delete
public class Test {

	public static void main(String[] args) {
		
		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql", "true");
//		props.put("hibernate.hbm2ddl.auto", "create"); // create (항상 새로 만든다), update ( 없으면 만들고, 있으면 변경되어야 하면 변경 )

		EntityManagerFactory emf = 
				new HibernatePersistenceProvider().createContainerEntityManagerFactory(
						new MyPersistenceUnitInfo(), props
				);
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			// #1 테이블 생성, 테스트 용도 entity 데이터 등록
//			{
//				Product p1 = new Product();
//				p1.setName("galaxy");
//				p1.setPrice(1000L);
//				p1.setQuantity(15);
//				p1.setCountry("korea");
//				
//				Product p2 = new Product();
//				p2.setName("iphone");
//				p2.setPrice(3000L);
//				p2.setQuantity(10);
//				p2.setCountry("usa");
//				
//				Product p3 = new Product();
//				p3.setName("galaxy note");
//				p3.setPrice(5000L);
//				p3.setQuantity(20);
//				p3.setCountry("korea");
//				
//				em.persist(p1);
//				em.persist(p2);
//				em.persist(p3);		
//			}

			// #2 Query
			// SQL  : select * from product   : product table 에서 전체 row 를 가져온다. * : 모든 컬럼
			// JPQL : select p from Product p : 모든 Product Entity 를 가져온다. p : p Entity 의 모든 필드
//			{
//				String jpql = "select p from Product p";
//				Query q = em.createQuery(jpql);  // 내부적으로 JDBC 의 PreparedStatement 사용
//				List<?> productList = q.getResultList(); // grid 형태의 ResultSet 구조의 결과를 return
//				
//				for (Object object : productList) {
//					Product p = (Product) object;
//					System.out.println(p);
//				}
//			}
			
			// #3 TypedQuery
//			{
//				String jpql = "select p from Product p";
//				TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//				List<Product> productList = q.getResultList();
//				
//				for (Product p : productList) {
//					System.out.println(p);
//				}
//			}
			
			// #4 TypedQuery + 개별 컬럼
			// Product 를  Object[] 대신 직접 받으려면 오류 발생
			// org.hibernate.query.QueryTypeMismatchException: Result type is 'Product' but the query returned a 'Integer'
//			{
//				String jpql = "select p.id, p.name, p.price from Product p";
//				TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//				List<Object[]> productList = q.getResultList();
//				
//				for (Object[] objArray : productList) {
//					System.out.println(objArray[0] + ", " + objArray[1] + ", " + objArray[2]);
//				}
//			}
			
			// #5 TypedQuery + where
//			{
//				String jpql = "select p from Product p where p.price > 2000";
//				TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//				List<Product> productList = q.getResultList();
//				
//				for (Product p : productList) {
//					System.out.println(p);
//				}
//			}		
			
			// #6 TypedQuery + where + and + param
//			{
//				String jpql = "select p from Product p where p.price > :price and p.quantity > :quantity";
//				TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//				q.setParameter("price", 2000);
//				q.setParameter("quantity", 10);
//				List<Product> productList = q.getResultList();
//				
//				for (Product p : productList) {
//					System.out.println(p);
//				}
//			}		
			
			// #7 TypedQuery + where + and + param with index
//			{
//				String jpql = "select p from Product p where p.price > ?1 and p.quantity > ?2";
//				TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//				q.setParameter(1, 2000);
//				q.setParameter(2, 10);
//				List<Product> productList = q.getResultList();
//				
//				for (Product p : productList) {
//					System.out.println(p);
//				}
//			}		
			
			// #8 TypedQuery + where + and + param + like
//			{
//				String jpql = "select p from Product p where p.name like :name";
//				TypedQuery<Product> q = em.createQuery(jpql, Product.class);
////				q.setParameter("name", "ga%");
////				q.setParameter("name", "%o%");
//				q.setParameter("name", "%note");
//				List<Product> productList = q.getResultList();
//				
//				for (Product p : productList) {
//					System.out.println(p);
//				}
//			}
			
			// #9 TypedQuery + aggregation function - count() + getSingleResult()
			// Long return
//			{
//				String jpql = "select count(p) from Product p";
//				TypedQuery<Long> q = em.createQuery(jpql, Long.class);
//				Long cnt = q.getSingleResult();
//				
//				System.out.println(cnt);
//			}
			
			// #10 TypedQuery + aggregation function - avg() + getSingleResult()
			// Double return
//			{
//				String jpql = "select avg(p.price) from Product p";
//				TypedQuery<Double> q = em.createQuery(jpql, Double.class);
//				Double cnt = q.getSingleResult();
//				
//				System.out.println(cnt);
//			}
				
			// #11 TypedQuery + aggregation function - sum(), min(), max() 동시 + getSingleResult()
//			{
//				String jpql = "select sum(p.quantity), min(p.quantity), max(p.quantity) from Product p";
//				TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//				Object[] objArray = q.getSingleResult();
//				
//				System.out.println(objArray[0] + ", " + objArray[1] + ", " + objArray[2]);
//				
//			}	
			
			// #12 TypedQuery + aggregation function - sum(), min(), max() + group by
//			{
//				String jpql = "select p.country, sum(p.quantity), min(p.quantity), max(p.quantity) from Product p group by p.country";
//				TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//				List<Object[]> objArrayList = q.getResultList();
//				
//				for (Object[] objArray : objArrayList) {
//					System.out.println(objArray[0] + ", " + objArray[1] + ", " + objArray[2] + ", " + objArray[3]);
//				}
//			}
			
			// #13 Update, Delete
			// Query, executeUpdate()
			{
				// update
//				String jpql = "update Product p set p.name='kProduct' where p.country = 'korea'";
				// delete
				String jpql = "delete Product p where p.country = 'korea'";
				Query q = em.createQuery(jpql);
				int cnt = q.executeUpdate();
				System.out.println(cnt);
			}
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}

}