package ca.pfv.spmf.test;

import ca.pfv.spmf.algorithms.frequentpatterns.CLS_Miner.AlgoCLS_miner;
import ca.pfv.spmf.algorithms.frequentpatterns.HMiner_CLosed.AlgoHMiner_Closed;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;


/**
 * Dam T L, CLS-Miner: efficient and effective closed high-utility itemset mining[J]. Frontiers of Computer Science, 2019, 13(2): 357-381.
 * This is a recurrent of the CLS-Miner Algorithm published in 2019
 * Use the CHUI-Miner(with EUCS) to help
 * use utility-list structure
 * This algo use three strategies called
 * 链估计效用共现剪枝（chain-estimated utility co-occurrence pruning），低枝剪枝（lower branch pruning）、覆盖剪枝（pruning by coverage.）
 */

public class MainTestCLS_Miner {

	public static void main(String [] arg) throws IOException{
		// input file path
		String input = fileToPath("dataset/Retail.txt");
		// the minutility threshold
		//      int [] minutil_Array= {500000,1000000,2000000,3000000,4000000,5000000};//Chainstore
//		int [] minutil_Array= {10000000,12000000,14000000,16000000,18000000,20000000};//Connect
//		int [] minutil_Array= {5000,10000,20000,30000,40000,50000};//Retail
// 		int [] minutil_Array= {10000,20000,30000,40000,50000,60000};//Mushroom
//		int [] minutil_Array= {1000,1500,2000,2500,3000,3500};//Foodmart
//		int [] minutil_Array= {22500000,25000000,27500000,28000000,28500000,29000000};//accidents
//		int [] minutil_Array= {2240000,2250000,2260000,2270000,2280000,2290000};//BMS
//		int [] minutil_Array= {350000,400000,450000,500000,550000,600000};//chess
//      int[] minutil_Array = {1200000, 1500000, 1800000, 2100000, 2400000, 2700000};//kosarak
//		int [] minutil_Array= {12000000,12100000,12200000,12300000,12400000,12500000};//pumsb
		int min_utility = 50;
		
		// output file path
		String output = ".//output.txt";
//		for (int minutil_t : minutil_Array) {
//			// Run the EFIM algorithm
//			AlgoCLS_miner clsMiner = new AlgoCLS_miner(true,false,true,true);
//			clsMiner.runAlgorithm(input, minutil_t, output);
//			System.out.println("Minutil :" + minutil_t);
//			System.out.println("Dataset :" + input);
//			clsMiner.printStats();
//		}
		// (1) Applying the CHUI-Miner algorithm to find 
		// closed high utility itemsets (CHUIs)
		AlgoCLS_miner clsMiner = new AlgoCLS_miner(true,false,true,true);
		clsMiner.runAlgorithm(input, min_utility, output);
		clsMiner.printStats();
	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestCLS_Miner.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
