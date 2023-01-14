package org.capillary.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.capillary.Iservice.Iservice;
import org.capillary.players.players;
import org.springframework.stereotype.Service;

@Service
public class serviceImpl implements Iservice{
players p=new players();
public ArrayList<Integer> start()
	{
		ArrayList<Integer> l=new ArrayList<Integer>();
		p.setP1(0);
		p.setP2(0);
		//Z=0 for player1 and Z=1 for player2
		p.setZ(0);
		l.add(0);
		l.add(0);
		l.add(0);
		return l;
	}
public ArrayList<Integer> dice_count()
	{
		int a=p.getP1();
		int b=p.getP2();
		ArrayList<Integer> l=new ArrayList<Integer>();
		//snake heads
		ArrayList<Integer> sh=new ArrayList<Integer>(Arrays.asList(99,95,92,89,74,64,62,46,49,16));
		//snake tails
		ArrayList<Integer> st=new ArrayList<Integer>(Arrays.asList(80,75,88,68,53,60,19,25,11,6));
		//ladder top
		ArrayList<Integer> th=new ArrayList<Integer>(Arrays.asList(38,14,26,31,44,42,84,67,98,94,91));
		//ladder bottom
		ArrayList<Integer> tt=new ArrayList<Integer>(Arrays.asList(2,7,15,8,36,21,28,51,78,87,71));
		
		Random rn=new Random();
		int r=rn.nextInt(7);
		while(r<1)
		{
			r=rn.nextInt(7);
		}
		if(p.getZ()==0)
		{
			if((a+r)<=100) {
			a=a+r;
			}
			//whether Player1 position in head of snake
			if(sh.contains(a))
			{
				a=st.get(sh.indexOf(a));
			}
			//whether Player1 position in bottom of ladder
			if(tt.contains(a))
			{
				a=th.get(tt.indexOf(a));
			}
			p.setZ(1);
		}
		else{
			if((b+r)<=100) {
			b=b+r;
			}
			//whether Player2 position in head of snake
			if(sh.contains(b))
			{
				b=st.get(sh.indexOf(b));
			}
			//whether Player2 position in bottom of ladder
			if(tt.contains(b))
			{
				b=th.get(tt.indexOf(b));
			}
			p.setZ(0);;
		}
		p.setP1(a);
		p.setP2(b);
		l.add(a);
		l.add(b);
		l.add(r);
		return l;
	}

}