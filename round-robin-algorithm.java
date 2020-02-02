import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RR extends GraphicsProgram
{

	Font f;
	Thread th;
	int c=3;
	int i,j,x,y;
	String str,input;
	char[] input_c;
	String[] parent={"11111","22222","33333","44444","55555"};
	String[] show=new String[600];
	String temp_s;
	
	Deque outer=new LinkedList();	
	Deque temp_outer=new LinkedList();	
	Deque in=new LinkedList();
	Deque read=new LinkedList();
	Deque pop_outer=new LinkedList();
	char pops;
	char pops_check;
		
	char[] ch0=new  char[5];	
	char[] ch;
	
	int count=1;
	String Random_String;
	
	int t,t_pause;
	int flag=1;
	int control=0;

	 
	 String input_update="";

	 int c1=0;

	 GImage gimage = new GImage("C:/images/cloud.png");
	 
	 int m,n;
	
	 String over;
	 
	 Deque bubble=new LinkedList();
	 
	 GImage blank= new GImage("C:/images/A9X2.png");
	 
	 int counter;
	 
	 Iterator itr_outer,itr_in;
	 
	 String gen;
	 
	 TextField tf=new TextField("");
	 
	 GLabel glabel;
	 
	 int last=0;
	 
	 int parallel,direction,remember;
	 
	 GImage blue=new GImage("C:/images/cloud.png");
	 
	 GImage splash=new GImage("C:/images/message.png"); 	
	 
	 String pops_str;
	 
	 GLabel pops_label;
	 
	 int tic_tic=0;
	 
	 int interpret=0;
	 
	 GLabel title=new GLabel("Round-Robin Scheduling SIMULATION");
	 
	 String inter_string;
	 
	 char[] inter_ch;
	 
	 int res_prob;
	 
	 long start,current,diff;
	 
	 int button=1;
	 
	 GImage on=new GImage("C:/images/on.png");
	 
	 GImage off=new GImage("C:/images/off.png");
	 
	    private JLabel label = new JLabel("                       Select Priority");
	    private JTextField nameField = new JTextField(20);
	    private JButton low = new JButton("Low");
	    private JButton high = new JButton("High");	 
	    private JLabel label_term = new JLabel("                     Notification Panel");
	    private String nameInput = "";
	    
	 String[]  pops_dyn=new String[8];
	 int dyn=1,dn;
	   
	 GImage gear=new GImage("C:/images/gearblur2.png");
	 
	 GLabel count_notify;
	 String string_notify="1";
	 int x_notify=1450+49 , y_notify=20+128;
	 GImage count_image=new GImage("C:/images/cnt.png");
	 
	 int dyns=1;
	   
	 GImage gears=new GImage("C:/images/gearblur2s.png");
	 
	 GLabel count_notifys;
	 String string_notifys="1";
	 int x_notifys=1450+49 , y_notifys=20+128+370;
	 GImage count_images=new GImage("C:/images/cnts.png");

	 Deque parallq=new LinkedList();
	 String paralltop;
	 

	 JTextArea terminal=new JTextArea("");/////////////////////////
	 String terminal_append;
	 
	 JTextArea time_label=new JTextArea("");
	 DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	 Calendar cali;
	 String time;
	 JLabel time_ttl=new JLabel("                               TIME");
	 
	 JLabel ttl=new JLabel("Round-Robin Scheduling SIMULATION");
	 
	 GLabel title_burst=new GLabel("CPU BURST");
	 
	 GLabel title_speed=new GLabel("SIMULATION SPEED");
	 
	 GLabel title_me1=new GLabel("By Dhaval Kadia");
	 GLabel title_me2=new GLabel("Faculty of Technology & Engineering");
	 GLabel title_me3=new GLabel("M.S. University if Baroda");
	 
	 Font f2;
	 
	 
public void init()
{ 
	
	th=new Thread(this);
	f=new Font("Arial",10 , 10);
	f2=new Font("Arial",10 , 30);
	setFont(f);	
	
	add(ttl,EAST);
	add(time_ttl,EAST);
	
	time_label.setFont(f2);
	time_label.setBackground(new Color(214,210,255));
	add(time_label,EAST);
	
	
	add(label, EAST);
    add(nameField, EAST);
    nameField.setBackground(new Color(225,255,255));
    
    nameField.addActionListener(this);
    add(high, EAST);
    add(low, EAST);
    addActionListeners();
    
	add(label_term, EAST);
    
    terminal.setPreferredSize( new Dimension( 20, 750 ) );
    add(terminal,EAST);
    
	terminal.setFont(f);
	terminal.setBackground(new Color(255,255,225));
    
    addMouseListener( this );
    addMouseMotionListener( this );
    
    count_notify=new GLabel(""+string_notify);
    add(count_notify,x_notify,y_notify);
   
    
		
	    tf.setLocation(900,700);
	    tf.setSize(50,50);
	     
	    tf.addKeyListener(this);	
		
		
		setVisible(true);

		
 try{
		
		for(i=0;i<parent.length;i++)
		{
		last++;
		input_c=parent[i].toCharArray();
		
        cali = Calendar.getInstance();
        cali.getTime();
        time = timeFormat.format(cali.getTimeInMillis());
        
        terminal_append="\nADDED : "+parent[i]+" @ "+time;
        
        terminal.append(terminal_append);
		
		Queue temp_c_pq=new LinkedList();
		
		 for(j=0;j<input_c.length;j++)
			temp_c_pq.add(input_c[j]);
					
		
			outer.add(temp_c_pq);	
			
			parallq.add(parent[i]);
		}
			
		
	}catch(Exception e){}
 
		th.start(); 
}
	


public void paint(Graphics g)
{		

	
	itr_outer=outer.iterator();
	
	if(flag==1)
	{
		counter=1;
		
		
		glabel=new GLabel(""+pops);
		
		add(glabel,10,20);
		
		GImage[] garr=new GImage[500];
		
		
		
		String gen;
		
		add(blank,0,0);	
		
		add(title,1455,920);
		
		add(on,1510,800);
		add(gear,1450,20);
		
		add(count_image,x_notify,y_notify);		
		count_notify=new GLabel(""+string_notify);
	    add(count_notify,x_notify+12,y_notify+20);
			
	    add(gears,1450,390);
	    add(count_images,x_notifys,y_notifys);		
		count_notifys=new GLabel(""+string_notifys);
	    add(count_notifys,x_notifys+12,y_notifys+20);
	    
	    add(title_burst,1515,250);
	    add(title_speed,1500,620);
	    add(title_me1,1500,700);
	    add(title_me2,1440,715);
	    add(title_me3,1482,730);

		
		itr_in=((Collection) itr_outer.next()).iterator();	
		
		int cur_pos=0;
		
		try{
			
		if(interpret==1)
		{
			
			read=(Deque) outer.peekFirst();
			
			dn=0;
			
			while((dn<dyn) && itr_in.hasNext() )
				{
					pops_dyn[dn]=""+(char)read.pollFirst();
					
					dn++;
					
					cur_pos++;
				}
			
			interpret=0;
			
			res_prob=1;	
			
			itr_in=((Collection) itr_outer.next()).iterator();
			
		}
		else
		{
			if(res_prob==0)
				{
					dn=0;
				
					while((dn<dyn) && itr_in.hasNext() )
						{
							pops_dyn[dn]=""+(char)itr_in.next();
						
							
							dn++;
							
							cur_pos++;
						}
				}
		}
		}catch(Exception e){}
		
		
		pops_label=new GLabel(pops_str);
		
		GImage[] garrdyn=new GImage[7];
		
		if(t>-20)
		{
			for(dn=0;dn<cur_pos;dn++)
			{
				gen="C:/images/"+"cloud - Copy ("+counter+").png"; //cloud - Copy (510)
				
				garr[counter]=new GImage(gen);
											
				pops_label=new GLabel(pops_dyn[dn]);
			
				add(garr[counter],50*(dn+1)+t*2, 50+t*2);
			
				add(pops_label,50*(dn+1)+t*2+20,75+t*2);
				
				counter++;
			}
			
			
		}
		else
		{
			
			for(dn=0;dn<cur_pos;dn++)
			{
				garrdyn[dn]=new GImage("C:/images/message - Copy ("+dn+").png");
			
				pops_label=new GLabel(pops_dyn[dn]);
			
				add(garrdyn[dn],50*dn+10,10);
				
			
				add(pops_label,50*dn+10+20,10+25);
				
				counter++;
			}
			
			
		}
		
		if(direction==2)
			n=1;
		else
			n=2;
		
			
		
		
		while(itr_in.hasNext())
		{
			over=""+(char)itr_in.next();			
			
			gen="C:/images/"+"cloud - Copy ("+counter+").png";
			
			garr[counter]=new GImage(gen);
			
			glabel=new GLabel(over);
			
			
				
			if(direction==0)
			{
				tic_tic=0;
				
				if(parallel>12)
				{
					add(garr[counter], n*50 + 700, 50 );					
				
					add(glabel, n*50+ 700+20, 50 +25 );
					
				}
				else
				{
					add(garr[counter], n*50 + parallel*50, 50 );					
			
					add(glabel, n*50+parallel*50 +20, 50 +25 );
				}
			}
			else if(direction==1)
			{
				if(parallel>( last-1 ))
				{
					add(garr[counter], 700 + n*50,  last*50  );		

					add(glabel, 700+20 +n*50 ,  last*50 +25 );
				}
				else
				{
				add(garr[counter], 700 + n*50,  parallel*50 );	
				
						

				add(glabel, 700+20 +n*50,  parallel*50 +25 );
				}
			}
			else if(direction==2)
			{
				if(parallel<-10)
				{
					add(garr[counter], n*50 , last*50+30 +tic_tic/1.2 );
					
					add(glabel,n*50 +20, last*50+30 +25 +tic_tic/1.2 );
					
					tic_tic--;
					
				}
				else
				{
				add(garr[counter],700+ n*50 + parallel*50, last*50 +23);	
				
				add(glabel,700+ n*50+parallel*50 +20, last*50+25 +25 );
				}
				
				
			}
			
			
			n++;
			counter++;
		}
		
		m=1;
		
		
		while(itr_outer.hasNext())		
		{
						
			itr_in=((Collection) itr_outer.next()).iterator();
	
			n=1;
	
			while(itr_in.hasNext())
			{
				over=""+(char)itr_in.next();			
				
				gen="C:/images/"+"cloud - Copy ("+counter+").png";
				
				garr[counter]=new GImage(gen);
					
				add(garr[counter], n*50 , 50*m +t +50);
				
				glabel=new GLabel(over);						
				
				add(glabel, n*50 +20, 50*m +25 +t +50);
				
				n++;
				counter++;
			}
			
			m++;
		}		

	}
else
	{

		add(blank,0,0);
		
		add(title,1455 ,920);

			add(on,1510,800);
			add(gear,1450,20);
			
			add(count_image,x_notify,y_notify);	
			count_notify=new GLabel(""+string_notify);
		    add(count_notify,x_notify+12,y_notify+20);
		    
		    add(gears,1450,390);
		    add(count_images,x_notifys,y_notifys);		
			count_notifys=new GLabel(""+string_notifys);
		    add(count_notifys,x_notifys+12,y_notifys+20);
		    
		    add(title_burst,1515,250);
		    add(title_speed,1500,620);
		    add(title_me1,1500,700);
		    add(title_me2,1440,715);
		    add(title_me3,1482,730);
			
			add(splash,10,10);
			
			add(pops_label,10+20,10+25);
			
			GImage[] garr=new GImage[500];
			
			counter=1;
			
				for(int u=0;u<input_c.length;u++)
				{
					inter_string=""+input_c[u];
					
					gen="C:/images/"+"cloud - Copy ("+counter+").png";
					
					garr[counter]=new GImage(gen);
					
					add(garr[counter],t+50*u, last*50 );
					
					glabel=new GLabel(inter_string);
					
					
					add(glabel, t+50*u+15,last*50+ 25 );
					
					counter++;
				}
				

			{
				m=1;
				
				
				while(itr_outer.hasNext() && m<last )		
				{
					
					itr_in=((Collection) itr_outer.next()).iterator();
									

					n=1;
					
					while(itr_in.hasNext())
					{
						over=""+(char)itr_in.next();		
						gen="C:/images/"+"cloud - Copy ("+counter+").png";
						
						
						garr[counter]=new GImage(gen);
							
						add(garr[counter], n*50 , 50*m );
						
						
						glabel=new GLabel(over);
						
						add(glabel,n*50 + 15, 50*m+25);

						n++;
						counter++;
					}
					
					m++;
				}
			}
			
	}
		
}
	
	
	
public void run()
{		
	
	 final GRect rect = new GRect(1510, 800, 102, 62);
	 rect.setFilled(true);
     rect.setColor(Color.white);
     add(rect);
     
     rect.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	
        	 
             if(button==1)
            	 {
            	 button=0;
            	 }
             else
            	 button=1;
            
         }
     });
     
	
     final GRect gear1 = new GRect(1450+49 ,20+128 ,30,30);
	 gear1.setFilled(true);
     gear1.setColor(Color.white);
     add(gear1);
     
     gear1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=1;        	 
        	
        	string_notify="1";
        	x_notify=1450+49;
        	y_notify=20+128;
            
         }
     });

     final GRect gear2 = new GRect(1450+28 ,20+86 ,30,30);
     gear2.setFilled(true);
     gear2.setColor(Color.white);
     add(gear2);
     
     gear2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=2;
        	
        	string_notify="2";
        	x_notify=1450+28;
        	y_notify=20+86;
            
         }
     });
     final GRect gear3 = new GRect(1450+49 ,20+47 ,30,30);
     gear3.setFilled(true);
     gear3.setColor(Color.white);
     add(gear3);
     
     gear3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=3;
        	
        	string_notify="3";
        	x_notify=1450+49;
        	y_notify=20+47;
            
         }
     });
     
     final GRect gear4 = new GRect(1450+90 ,20+29 ,30,30);
     gear4.setFilled(true);
     gear4.setColor(Color.white);
     add(gear4);
     
     gear4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=4;
        	
        	string_notify="4";
        	x_notify=1450+90;
        	y_notify=20+29;

         }
     });
 
     final GRect gear5 = new GRect(1450+130 ,20+45 ,30,30);
     gear5.setFilled(true);
     gear5.setColor(Color.white);
     add(gear5);
     
     gear5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=5;
        	
        	string_notify="5";
        	x_notify=1450+130;
        	y_notify=20+45;
            
         }
     });

     final GRect gear6 = new GRect(1450+148 ,20+88 ,30,30);
     gear6.setFilled(true);
     gear6.setColor(Color.white);
     add(gear6);
     
     gear6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	dyn=6;
        	
        	string_notify="6";
        	x_notify=1450+148;
        	y_notify=20+88;
            
         }
     });
   
     final GRect gear7 = new GRect(1450+130 ,20+130,30,30);
     gear7.setFilled(true);
     gear7.setColor(Color.white);
     add(gear7);
     
     gear7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
          
        	 dyn=7;
        	 
        	string_notify="7";
         	x_notify=1450+130;
         	y_notify=20+130;
            
         }
     });
        
          
final GRect gear1s = new GRect(1450+49 ,20+128+370 ,30,30);
gear1s.setFilled(true);
gear1s.setColor(Color.white);
add(gear1s);

gear1s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=1;        	 

string_notifys="1";
x_notifys=1450+49;
y_notifys=20+128+370;

}
});

final GRect gear2s = new GRect(1450+28 ,20+86 +370,30,30);
gear2s.setFilled(true);
gear2s.setColor(Color.white);
add(gear2s);

gear2s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=2;

string_notifys="2";
x_notifys=1450+28;
y_notifys=20+86+370;

}
});

final GRect gear3s = new GRect(1450+49 ,20+47+370 ,30,30);
gear3s.setFilled(true);
gear3s.setColor(Color.white);
add(gear3s);

gear3s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=3;

string_notifys="3";
x_notifys=1450+49;
y_notifys=20+47+370;

}
});

final GRect gear4s = new GRect(1450+90 ,20+29+370 ,30,30);
gear4s.setFilled(true);
gear4s.setColor(Color.white);
add(gear4s);

gear4s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=4;

string_notifys="4";
x_notifys=1450+90;
y_notifys=20+29+370;

}
});

final GRect gear5s = new GRect(1450+130 ,20+45 +370,30,30);
gear5s.setFilled(true);
gear5s.setColor(Color.white);
add(gear5s);

gear5s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=5;

string_notifys="5";
x_notifys=1450+130;
y_notifys=20+45+370;

}
});

final GRect gear6s = new GRect(1450+148 ,20+88+370 ,30,30);
gear6s.setFilled(true);
gear6s.setColor(Color.white);
add(gear6s);

gear6s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=6;

string_notifys="6";
x_notifys=1450+148;
y_notifys=20+88+370;

}
});

final GRect gear7s = new GRect(1450+130 ,20+130+370,30,30);
gear7s.setFilled(true);
gear7s.setColor(Color.white);
add(gear7s);

gear7s.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

dyns=7;

string_notifys="7";
x_notifys=1450+130;
y_notifys=20+130+370;

}
});

	boolean b=true;
	
	try{
		b=outer.isEmpty();
	}catch(Exception e){}
	
	while(!b)
	{	
            
	                cali = Calendar.getInstance();
	                cali.getTime();
	                time = timeFormat.format(cali.getTimeInMillis());
	           
	                time_label.setText("      "+time);

		
	if(count % 5 == 0)
	{
		Random_String="Periodic"+count;
		
		parallq.addLast(Random_String);
		
		input_c=Random_String.toCharArray();
		
		Queue temp_c_pq=new LinkedList();		
		
		 for(y=0;y<input_c.length;y++)		 
			temp_c_pq.add(input_c[y]);		 
		
		outer.addLast(temp_c_pq);	
		
		
        cali = Calendar.getInstance();
        cali.getTime();
        time = timeFormat.format(cali.getTimeInMillis());
        
        terminal_append="\nADDED : Periodic"+count+" @ "+time;
		
		
		terminal.append(terminal_append);
		
		last++;
		
		flag=0;
		
		for( t=500;t>50;t=t=t-50)
		{
            cali = Calendar.getInstance();
            cali.getTime();
            time = timeFormat.format(cali.getTimeInMillis());
            time_label.setText("      "+time);
			
			if(button==0)
			{
				int o=1;
				
				while(o==1)
				{
					add(off,1510,800);
					
					if(button==1)
						o=0;
					
					try	{Thread.sleep(50/dyns);}	catch(Exception e){}
				}
			}
			
			repaint();
			try	{Thread.sleep(200/dyns);}	catch(Exception e){}
		}
	}
	else
	{	
		
		boolean a=true;
		
		read=(Deque) outer.peekFirst();
		
		
		try{
			a=read.isEmpty();
		}catch(NullPointerException e){}
		
		
	if(read.isEmpty())
	{
		try{
		outer.remove();

		
        cali = Calendar.getInstance();
        cali.getTime();
        time = timeFormat.format(cali.getTimeInMillis());
        
        terminal_append="\nENDED : "+parallq.pollFirst()+" @ "+time;
		
		terminal.append(terminal_append);
		
		
		last--;
		
		}catch(Exception e){}
	}
	else
	{
		parallel=1;
		direction=0;
		int par=1;
		
		
		for( t=1;t>-40;t-=1)
		{
            cali = Calendar.getInstance();
            cali.getTime();
            time = timeFormat.format(cali.getTimeInMillis());
            time_label.setText("      "+time);
			
			if(par%13==0)
			{
				
				if(direction<2)
				{
					direction++;
					parallel=1;
				}

			}
			
			if(direction==2)
				parallel-=1;
			else if(direction==1)
				parallel++;		
			else if(direction==0)
				parallel+=2;
			
			par++;
			
			if(button==0)
			{
				int o=1;
				
				while(o==1)
				{
					add(off,1510,800);
					
					if(button==1)
						o=0;
					
					try	{Thread.sleep(50/dyns);}	catch(Exception e){}
				}
			}
			
			
	     	repaint();
			try	{Thread.sleep(200/dyns);}	catch(Exception e){}	//200
		}
		
		try{
			if(res_prob==0)
				{
					 dn=0;
					
					while( (dn<dyn) && (!read.isEmpty()) )
					{          
						pops=(char) read.pollFirst();
						
						dn++;
						
					}
				
				}
			
		}catch(Exception e){}

	try{
	if(!read.isEmpty())
		{	
	
		outer.add( outer.pollFirst() );
		
		parallq.add(parallq.pollFirst() );
		}
	
	}catch(Exception e){}
	
	}		
		
	}
	
	count++;
	flag=1;
	
	if(res_prob==1)			
		res_prob=0;	
	
	}	
}



public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}



public void keyTyped(KeyEvent ke) {
char ch=ke.getKeyChar();
	
	if(ch=='\n')
	{
		last++;
		
		inter_ch=input_update.toCharArray();
		
		Queue temp_c_pq=new LinkedList();		
		
		 for(y=0;y<inter_ch.length;y++)		 
			temp_c_pq.add(inter_ch[y]);		 
		
		outer.addFirst(temp_c_pq);	
		
		input_update="";
		
		tf.setText(" ");
		
		interpret=1;
	}
	else
	{
		input_update+=""+ch;
	}
	
}



public void actionPerformed(ActionEvent e) {
	
    if(e.getSource() == low || e.getSource() == nameField) 
    {
        last++;
		
        parallq.addLast(nameField.getText());
        
		inter_ch=nameField.getText().toCharArray();
		
		Queue temp_c_pq=new LinkedList();		
		
		 for(y=0;y<inter_ch.length;y++)		 
			temp_c_pq.add(inter_ch[y]);		 
		
		outer.addLast(temp_c_pq);	
		
		nameField.setText("");
		
		interpret=1;
		
        cali = Calendar.getInstance();
        cali.getTime();
        time = timeFormat.format(cali.getTimeInMillis());
        
        terminal_append="\nADDED_INTRPT_LOW : "+parallq.peekLast()+" @ "+time;
		
		terminal.append(terminal_append);
		

      
    }
    if(e.getSource() == high) {
       
    	last++;
    	
    	parallq.addFirst(nameField.getText());
		
		inter_ch=nameField.getText().toCharArray();
		
		Queue temp_c_pq=new LinkedList();		
		
		 for(y=0;y<inter_ch.length;y++)		 
			temp_c_pq.add(inter_ch[y]);		 
		
		outer.addFirst(temp_c_pq);	
		
		interpret=1;
        
        nameField.setText(" ");
        
        
        cali = Calendar.getInstance();
        cali.getTime();
        time = timeFormat.format(cali.getTimeInMillis());
        
        terminal_append="\nADDED_INTRPT_HIGH : "+parallq.peekFirst()+" @ "+time;
		
		terminal.append(terminal_append);
    }
}
}