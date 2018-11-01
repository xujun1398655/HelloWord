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
		//ȫ���ǻỰ������в���
		//������� save����Ϊ�����������
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//		Session s = sf.openSession();
//		s.beginTransaction();
//
//		Product p = new Product();
//		p.setName("iphone7");
//		p.setPrice(7000);
//		s.save(p);//��session���б��棬�־õ�
//
//		s.getTransaction().commit();
//		s.close();
//		sf.close();
		
		//��֤״̬
//		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		Product p=new Product();//˲ʱ��
//		p.setName("����");
		
		//���ǲ�ѯ��ͨ��id��ȡ����
//		Product p=(Product)s.get(Product.class, 1);
//		System.out.println("idΪ1��product����Ϊ:"+p.getName());
		
		//ɾ����ͨ��id��ȡ������delete�������ɾ��
//		s.delete(p);//����ʧ�ܣ�����ɾ��һ�������ݣ��²�����ø��½���ʵ��
		//ͨ��hql�����в�ѯ   ���룺�ǶԱ�����Ӧ�������sql���ӳ��
//		String name="iphone";
//		Query q=s.createQuery("from Product p where p.name like ?");
//		q.setString(0, "%"+name+"%");//�����ѯӦ�����ڲ���Ҫ�ġ�setString?
//		List<Product> ps=q.list();
//		for(Product p : ps){
//			System.out.println(p.getName());
//		}
		
		//ͨ��criteria���в�ѯ   ģ����ѯcreateCriteria
//		String name="iphone";
//		Criteria c=s.createCriteria(Product.class);
//		c.add(Restrictions.like("name", "%"+name+"%"));
//		List<Product> ps=c.list();
//		for(Product p:ps){
//			System.out.println(p.getName()+"  "+p.getPrice());
//		}
		
		//��׼sql�����в�ѯ 
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
		
        //���Զ��һ�Ĺ�ϵ��many-to-one
//		Category c=new Category();
//		c.setName("c1");
//		s.save(c);
//		Product p=(Product)s.get(Product.class, 8);
//		p.setCategory(c);
//		s.update(p);
		
		//����һ�Զ��ϵ
//		Category c=(Category)s.get(Category.class, 1);
//		Set<Product> ps=c.getProducts();
//		for(Product p:ps){
//			System.out.println(p.getName()+"  "+p.getPrice());
//		}
		//���Զ�Զ��ϵ
//		Set<User> users=new HashSet<User>();
//		//����3��user
//		for(int i=0;i<3;i++){
//			User u=new User();
//			u.setName("user"+i);
//			users.add(u);
//			s.save(u);
//		}
//		Product p1=(Product)s.get(Product.class,1);
//		p1.setUsers(users);
//		s.save(p1);
		
		//Hibernate���κζ������иĶ��Ĳ�������Ӧ�ñ�������������.
		//�������еĶ��������Ϊ��Ҫô���ɹ���Ҫô��ʧ��
//		Product p=(Product)s.get(Product.class, 1);
//		s.delete(p);
		
//		Product p2=(Product)s.get(Product.class, 2);
//		p2.setName(".............................................................................................................");
//		s.update(p2);
		
		//get �� load ���
//		Product p=(Product)s.get(Product.class, 2);
//		System.out.println("log1");
//		System.out.println(p.getName());
//		System.out.println("log2");
//		Product p2=(Product)s.load(Product.class, 3);
//		System.out.println("log3");
//		System.out.println(p2.getName());
//		System.out.println("log4");
		
		//��������delete
//		Category c=(Category)s.get(Category.class, 1);
//		s.delete(c);
//		Category c=new Category();
//		c.setId(5);//�����Զ��������޷�����id����
//		c.setName("yingpin");
//		s.save(c);
		//��������save-update
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
		
//		s.save(p);//save�־õ�
//		s.getTransaction().commit();
//		s.close();//�Ͽ� �ѹ�״̬
//		sf.close();
		//��criteria���з�ҳ��ѯ
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String name="iphone";
		Criteria c=s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(3);//��ʼ�����ݣ���0��ʼ����0
		c.setMaxResults(2);//�����ʾ��Ŀ
		List<Product> sp=c.list();
		for(Product p:sp){
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		//ɾ�����ݼ��Ȼ�ȡ����get����load��������Ȼ���ٽ���deleteɾ������
//		Product p=(Product)s.get(Product.class, 1);
//		s.delete(p.getName());
		//update�������Զ�����в���
//		Product p=(Product)s.get(Product.class, 1);
//		p.setName("�޸ĵ�����");
//		p.setPrice(213);
//		s.update(p);
		
	}

}