package com.how2java.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import com.how2java.pojo.User;

public class TestHibernate {
	public static void main(String[] args) {
		//全都是会话对象进行操作
		//插入操作 save对象即为插入对象数据
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//		Session s = sf.openSession();
//		s.beginTransaction();
//
//		Product p = new Product();
//		p.setName("iphone7");
//		p.setPrice(7000);
//		s.save(p);//用session进行保存，持久的
//
//		s.getTransaction().commit();
//		s.close();
//		sf.close();
		
		//验证状态
//		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		Product p=new Product();//瞬时的
//		p.setName("测试");
		
		//不是查询，通过id获取对象
//		Product p=(Product)s.get(Product.class, 1);
//		System.out.println("id为1的product数据为:"+p.getName());
		
		//删除：通过id获取对象来delete对象进行删除
//		s.delete(p);//测试失败，不能删除一部分数据，猜测可以用更新进行实现
		//通过hql语句进行查询   猜想：是对表所对应的类进行sql语句映射
//		String name="iphone";
//		Query q=s.createQuery("from Product p where p.name like ?");
//		q.setString(0, "%"+name+"%");//这个查询应该是内部必要的。setString?
//		List<Product> ps=q.list();
//		for(Product p : ps){
//			System.out.println(p.getName());
//		}
		
		//通过criteria进行查询   模糊查询createCriteria
//		String name="iphone";
//		Criteria c=s.createCriteria(Product.class);
//		c.add(Restrictions.like("name", "%"+name+"%"));
//		List<Product> ps=c.list();
//		for(Product p:ps){
//			System.out.println(p.getName()+"  "+p.getPrice());
//		}
		
		//标准sql语句进行查询 
//		String name="iphone";
//		String sql="select * from product_ p where p.name like '%"+name+"%'";
//		Query q=s.createSQLQuery(sql);
//		List<Object[]> ps=q.list();
//		for(Object[] oa:ps){
//			for(Object ob:oa){
//				System.out.println(ob+"\t");
//			}
//			System.out.println();
//		}
		
        //测试多对一的关系，many-to-one
//		Category c=new Category();
//		c.setName("c1");
//		s.save(c);
//		Product p=(Product)s.get(Product.class, 8);
//		p.setCategory(c);
//		s.update(p);
		
		//测试一对多关系
//		Category c=(Category)s.get(Category.class, 1);
//		Set<Product> ps=c.getProducts();
//		for(Product p:ps){
//			System.out.println(p.getName()+"  "+p.getPrice());
//		}
		//测试多对多关系
//		Set<User> users=new HashSet<User>();
//		//插入3个user
//		for(int i=0;i<3;i++){
//			User u=new User();
//			u.setName("user"+i);
//			users.add(u);
//			s.save(u);
//		}
//		Product p1=(Product)s.get(Product.class,1);
//		p1.setUsers(users);
//		s.save(p1);
		
		//Hibernate的任何对数据有改动的操作，都应该被放在事务里面.
		//在事务中的多个操作行为，要么都成功，要么都失败
//		Product p=(Product)s.get(Product.class, 1);
//		s.delete(p);
		
//		Product p2=(Product)s.get(Product.class, 2);
//		p2.setName(".............................................................................................................");
//		s.update(p2);
		
		//get 与 load 差别
//		Product p=(Product)s.get(Product.class, 2);
//		System.out.println("log1");
//		System.out.println(p.getName());
//		System.out.println("log2");
//		Product p2=(Product)s.load(Product.class, 3);
//		System.out.println("log3");
//		System.out.println(p2.getName());
//		System.out.println("log4");
		
		//级联操作delete
//		Category c=(Category)s.get(Category.class, 1);
//		s.delete(c);
//		Category c=new Category();
//		c.setId(5);//设置自动增长后，无法设置id属性
//		c.setName("yingpin");
//		s.save(c);
		//级联操作save-update
//		Category c = (Category) s.get(Category.class, 2);
//        
//        Product p1 = new Product();
//        p1.setName("product_501");
//        Product p2 = new Product();
//        p2.setName("product_502");
//        Product p3 = new Product();
//        p3.setName("product_503");
// 
//        c.getProducts().add(p1);
//        c.getProducts().add(p2);
//        c.getProducts().add(p3);
		
//		s.save(p);//save持久的
//		s.getTransaction().commit();
//		s.close();//断开 脱管状态
//		sf.close();
		//用criteria进行分页查询
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String name="iphone";
		Criteria c=s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(3);//开始的数据，从0开始，基0
		c.setMaxResults(2);//最大显示数目
		List<Product> sp=c.list();
		for(Product p:sp){
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		//删除数据即先获取对象（get或者load方法），然后再进行delete删除操作
//		Product p=(Product)s.get(Product.class, 1);
//		s.delete(p.getName());
		//update操作即对对象进行操作
//		Product p=(Product)s.get(Product.class, 1);
//		p.setName("修改的数据");
//		p.setPrice(213);
//		s.update(p);
		
	}

}