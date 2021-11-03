package AIProject;

import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class Matrix extends GenericSearchProblem{
	
	public static void genGrid() {
		//System.out.println("awl 7aga");
		//Mai commented
		int M;
		int N;
		int NeoX;
		int NeoY;
		int TelephoneBoothX;
		int TelephoneBoothY;
		int C;
		int Hostages;
		ArrayList<Integer> HostagesLocation = new ArrayList<Integer>();
		int Agents;
		ArrayList<Integer> AgentsLocation = new ArrayList<Integer>();
		int Pills;
		ArrayList<Integer> PillsLocation = new ArrayList<Integer>();
		int Pads;
		ArrayList<Integer> PadsLocation = new ArrayList<Integer>();
		int AvailableSpots;
		
		
		M = (int)(Math.random()*11) +5;
		System.out.println("M = " + M);
		N = (int)(Math.random()*11) +5;
		System.out.println("N = " + N);
		NeoX = (int) (Math.random()*M);
		NeoY = (int) (Math.random()*N);
		System.out.println("Neo X = " + NeoX);
		System.out.println("Neo Y = " + NeoY);
		TelephoneBoothX = (int)(Math.random()*M);
		TelephoneBoothY = (int)(Math.random()*N);
		System.out.println("TelephoneBooth X = " + TelephoneBoothX);
		System.out.println("TelephoneBooth Y  = " + TelephoneBoothY);
		Hostages = (int)(Math.random()*11) + 3;
		C = (int)(Math.random()*4)+1;
		Pills = (int)(Math.random()*Hostages);
		
		
		
		//Hostages locations
		int HostageX;
		int HostageY;
		int HostageDamage;
		Boolean overlapswithself = false;
		System.out.println("Hostages = " + Hostages);
		for(int i=0; i<Hostages;i++) {
			HostageDamage = (int)(Math.random()*99)+1;

			do {
				overlapswithself = false;
				HostageX = (int)(Math.random()*M);
				HostageY= (int)(Math.random()*N);
				//System.out.println("Hostage X = " + HostageX);
				//System.out.println("Hostage Y = " + HostageY);
				for(int j = 0; j < HostagesLocation.size()-2; j+=3) {
					if(HostageX == HostagesLocation.get(j) && HostageY == HostagesLocation.get(j+1)) {
						overlapswithself = true;
					}
					//System.out.println(overlapswithself);
				}
			}while(HostageX == NeoX && HostageY == NeoY || HostageX == TelephoneBoothX && HostageY == TelephoneBoothY || overlapswithself);
			HostagesLocation.add(HostageX);
			HostagesLocation.add(HostageY);
			System.out.println("Hostage X = " + HostageX);
			System.out.println("Hostage Y = " + HostageY);
			HostagesLocation.add(HostageDamage);
		}
		System.out.println("hostages location");
		overlapswithself = false;
		
		//Pills locations
		int PillX;
		int PillY;
		Boolean Overlaps;
		for(int i=0; i<Pills;i++) {
			do {
				Overlaps = false;
				overlapswithself = false;
				PillX = (int)(Math.random()*M);
				PillY= (int)(Math.random()*N);
				Overlaps= false;
				for(int j = 0; j < HostagesLocation.size()-2; j+=3) {
					if(PillX == HostagesLocation.get(j) && PillY == HostagesLocation.get(j+1)) {
						Overlaps = true;
					}
				}
				for(int j = 0; j < PillsLocation.size()-1; j+=2) {
					if(PillX == PillsLocation.get(j) && PillY == PillsLocation.get(j+1)) {
						overlapswithself = true;
					}
				}
			}while(PillX == NeoX && PillY == NeoY || PillX == TelephoneBoothX && PillY == TelephoneBoothY || Overlaps == true || overlapswithself);
			PillsLocation.add(PillX);
			PillsLocation.add(PillY);
			System.out.println("Pill X = " + PillX);
			System.out.println("Pill Y = " + PillY);
		}
		System.out.println("pills location");
		overlapswithself = false;
		
		
		//Agents locations
		// changed area 
		int AgentX;
		int AgentY;
		AvailableSpots = (M*N) - (Hostages + Pills + 2);
		Agents = (int)(Math.random()*AvailableSpots+1);
		System.out.println("Agents = " + Agents);
		Boolean OverlapsHostages;
		Boolean OverlapsPills;
		for(int i=0; i<Agents;i++) {
			do {
				OverlapsHostages = false;
				OverlapsPills = false;
				AgentX = (int)(Math.random()*M);
				AgentY= (int)(Math.random()*N);
				OverlapsHostages= false;
				overlapswithself = false;
				//System.out.print("BYEEEEE");
				for(int j = 0; j < HostagesLocation.size()-2; j+=3) {
					if(AgentX == HostagesLocation.get(j) && AgentY == HostagesLocation.get(j+1)) {
						OverlapsHostages = true;
						//System.out.print("hiii");
					}
				}
				OverlapsPills= false;
				for(int j = 0; j < PillsLocation.size()-1; j+=2) {
					if(AgentX == PillsLocation.get(j) && AgentY == PillsLocation.get(j+1)) {
						OverlapsPills = true;
						//System.out.print("hiii AGAIN");
					}
				}
				for(int j = 0; j < AgentsLocation.size()-1; j+=2) {
					if(AgentX == AgentsLocation.get(j) && AgentY == AgentsLocation.get(j+1)) {
						overlapswithself = true;
					}
				}
			}while(AgentX == NeoX && AgentY == NeoY || AgentX == TelephoneBoothX && AgentY == TelephoneBoothY || OverlapsHostages || OverlapsPills || overlapswithself);
			AgentsLocation.add(AgentX);
			AgentsLocation.add(AgentY);
			System.out.println("Agent " + i);
			System.out.println("Agent X = " + AgentX);
			System.out.println("Agent Y = " + AgentY);
		}
		System.out.println("Agents location");
		
		
		//Pads locations
		int StartPadX;
		int StartPadY;
		
		int AvailableSpotsForPads = AvailableSpots - Agents;
		do {
			Pads = (int)(Math.random()*AvailableSpotsForPads)+1;
		}
		while(Pads%2!=0);
		System.out.println("Pads = " + Pads);
		Boolean OverlapsHostagesPads = false;
		Boolean OverlapsPillsPads = false;
		Boolean OverlapsAgents = false;
		overlapswithself = false;
		
		for(int i=0; i<Pads;i++) {
			System.out.println("iteration"+i);
			do {
				OverlapsHostagesPads = false;
				OverlapsPillsPads = false;
				OverlapsAgents = false;
				overlapswithself = false;
				
				StartPadX = (int)(Math.random()*M);
				StartPadY= (int)(Math.random()*N);
				//System.out.print("BYEEEEE");
				for(int j = 0; j < HostagesLocation.size()-2; j+=3) {
					if(StartPadX == HostagesLocation.get(j) && StartPadY == HostagesLocation.get(j+1)) {
						OverlapsHostagesPads = true;
						//System.out.print("hiii");
					}
				}
				for(int j = 0; j < PillsLocation.size()-1; j+=2) {
					if(StartPadX == PillsLocation.get(j) && StartPadY == PillsLocation.get(j+1)) {
						OverlapsPillsPads = true;
						//System.out.print("hiii AGAIN");
					}
				}
				for(int j = 0; j < AgentsLocation.size()-1; j+=2) {
					if(StartPadX == AgentsLocation.get(j) && StartPadY == AgentsLocation.get(j+1)) {
						OverlapsAgents = true;
					}
				}
				for(int j = 0; j < PadsLocation.size()-1; j+=2) {
					if(StartPadX == PadsLocation.get(j) && StartPadY == PadsLocation.get(j+1)) {
						overlapswithself = true;
					}
				}
			}while(StartPadX == NeoX && StartPadY == NeoY || StartPadX == TelephoneBoothX && StartPadY == TelephoneBoothY || OverlapsHostagesPads || OverlapsPillsPads || overlapswithself || OverlapsAgents);
			PadsLocation.add(StartPadX);
			PadsLocation.add(StartPadY);
			//System.out.println("Agent " + i);
			System.out.println("StartPad X = " + StartPadX);
			System.out.println("StartPad Y = " + StartPadY);
		}
//		for(int i=0; i<Pads;i++) {
//			do {
//				OverlapsHostagesPads = false;
//				OverlapsPillsPads = false;
//				overlapswithself = false;
//				OverlapsAgents = false;
//				StartPadX = (int)(Math.random()*M);
//				StartPadY= (int)(Math.random()*N);
//				
//				System.out.println("StartPad X = " + StartPadX);
//				System.out.println("StartPad Y = " + StartPadY);
//				
//				for(int j = 0; j < HostagesLocation.size(); j+=3) {
//					if(StartPadX == HostagesLocation.get(j) && StartPadY == HostagesLocation.get(j+1)) {
//						OverlapsHostagesPads = true;
//						System.out.println("First pad overlaps with hostages");
//						break;
//					}
//				}
//				for(int j = 0; j < PillsLocation.size(); j+=2) {
//					if(StartPadX == PillsLocation.get(j) && StartPadY == PillsLocation.get(j+1)) {
//						OverlapsPillsPads = true;
//						System.out.println("First pad overlaps with pills");
//						break;
//					}
//				}
//				for(int j = 0; j < PadsLocation.size(); j+=2) {
//					if(StartPadX == PadsLocation.get(j) && StartPadY == PadsLocation.get(j+1)) {
//						overlapswithself = true;
//						System.out.println("First pad overlaps with itself. iteration = " + i + " PadsLocation = " + PadsLocation);
//						break;
//					}
//				}
//				for(int j = 0; j < AgentsLocation.size(); j+=2) {
//					if(StartPadX == AgentsLocation.get(j) && StartPadY == AgentsLocation.get(j+1)) {
//						OverlapsAgents = true;
//						System.out.println("First pad overlaps with agents");
//						break;
//					}
//				}
//				System.out.println("Start pad");
//				
//				
//				
//			}while((StartPadX == NeoX && StartPadY == NeoY) || (StartPadX == TelephoneBoothX && StartPadY == TelephoneBoothY )|| OverlapsAgents || OverlapsHostagesPads || OverlapsPillsPads || overlapswithself);
//			System.out.println("ADDED PADS : ");
//			System.out.println("StartPad X = " + StartPadX);
//			System.out.println("StartPad Y = " + StartPadY);
//			
//			PadsLocation.add(StartPadX);
//			PadsLocation.add(StartPadY);
//		
//		}
		
		
		System.out.println("Terminated");
//		//Finish pad
//		for(int j = 0; j < HostagesLocation.size(); j+=3) {
//			if(FinishPadX == HostagesLocation.get(j) && FinishPadY == HostagesLocation.get(j+1)) {
//				OverlapsHostagesPads = true;
//				System.out.println("Finish pad overlaps with hostages");
//				break;
//			}
//		}
//		//OverlapsPills= false;
//		for(int j = 0; j < PillsLocation.size(); j+=2) {
//			if(FinishPadX == PillsLocation.get(j) && FinishPadY == PillsLocation.get(j+1)) {
//				OverlapsPillsPads = true;
//				System.out.println("Finish pad overlaps with pills");
//				break;
//			}
//		}
//		for(int j = 0; j < PadsLocation.size(); j+=2) {
//			if(FinishPadX == PadsLocation.get(j) && FinishPadY == PadsLocation.get(j+1)) {
//				overlapswithselfFinish = true;
//				System.out.println("Finish pad overlaps with itself");
//				break;
//			}
//		}
//		for(int j = 0; j < AgentsLocation.size(); j+=2) {
//			if(FinishPadX == AgentsLocation.get(j) && FinishPadY == AgentsLocation.get(j+1)) {
//				OverlapsAgents = true;
//				System.out.println("First pad overlaps with agents");
//				break;
//			}
//		}
			
			
		String output;
		output= Integer.toString(M)+","+Integer.toString(N)+";"+ Integer.toString(C)+";"+Integer.toString(NeoX)+","+Integer.toString(NeoY)+";"+Integer.toString(TelephoneBoothX)+","+Integer.toString(TelephoneBoothY)+";";
		for(int i=0;i<AgentsLocation.size();i++)
		{
			if(i<AgentsLocation.size()-1)
			output+=Integer.toString(AgentsLocation.get(i))+",";
			else
				output+=Integer.toString(AgentsLocation.get(i))+";";

		}
		for(int i=0;i<PillsLocation.size();i++)
		{
			if(i<PillsLocation.size()-1)
			output+=Integer.toString(PillsLocation.get(i))+",";
			else
				output+=Integer.toString(PillsLocation.get(i))+";";

		}
		for(int i=0;i<PadsLocation.size();i++)
		{
			if(i<PadsLocation.size()-1)
			output+=Integer.toString(PadsLocation.get(i))+",";
			else
				output+=Integer.toString(PadsLocation.get(i))+";";

		}
		for(int i=0;i<HostagesLocation.size();i++)
		{
			if(i<HostagesLocation.size()-1)
			output+=Integer.toString(HostagesLocation.get(i))+",";
			else
				output+=Integer.toString(HostagesLocation.get(i));

		}
		System.out.println(output);

		//return h;
		
	}
	
	public static String solve() {
		return null;
		
	}

	@Override
	int pathCost(SearchTreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		
		genGrid();
		
	}

	@Override
	Boolean goalTest(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String stateSpace(String state, Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}
 }