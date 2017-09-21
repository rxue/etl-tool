package ruixue.etl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ruixue.etl.config.RootConfiguration;
import ruixue.etl.service.LoadServiceMain;
public class Main {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		 context = new AnnotationConfigApplicationContext(RootConfiguration.class);
		 LoadServiceMain loader = context.getBean(LoadServiceMain.class);
		 loader.load("/home/dingding/Documents/jobsearch_tasks/FactGameTransaction_20150320.csv");
	}

}
