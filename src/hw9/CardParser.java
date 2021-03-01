package hw9;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class CardParser 
{
	private String urlString;
	private ArrayList<HearthstoneCard> theMinions;
	
	public CardParser(String urlString)
	{
		//initial fields
		this.urlString = urlString;
		theMinions = new ArrayList<HearthstoneCard>();
		
		URLReader hearthstoneURLReader = new URLReader(this.urlString);
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		
	    if(obj instanceof JSONArray)
	    {
	    	//I am only in here if obj IS a JSONArray
	    	JSONArray array = (JSONArray)obj;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			//I am only here is this is a minion card!!!
		    			System.out.println(cardData.keySet().toString());
		    			String name = (String)cardData.get("name");
		    			int cost = Integer.parseInt(cardData.get("cost").toString());
		    			int attack = Integer.parseInt(cardData.get("attack").toString());
		    			int health = Integer.parseInt(cardData.get("health").toString());
		    			HearthstoneCard temp = new HearthstoneCard(name, cost, attack, health);
		    			theMinions.add(temp);
		    		}
		    	}
		    	
		    }
	    }
	}
	
	public void showMinions()
	{
		for(int i = 0; i < this.theMinions.size(); i++)
		{
			this.theMinions.get(i).display();
		}
	}
	
	public void SortHighesttoLowest()
    {
        for(int i = 1; i < this.theMinions.size(); i++ )
        {
       
        	int ind = i;
        	HearthstoneCard temp; 
        	//boolean elst = true;
            while(i > 0 && this.theMinions.get(ind).getCost() < this.theMinions.get(ind-1).getCost())
            {
            	//Possibility 1
            	//if(i>0 && this.theMinions.get(ind-1).getCost() <= this.theMinions.get(ind).getCost())
            	//{	elst = false;
            		//break;}
            	
            	//Possibility 2
            	//if(int r = i + 1; r < this.theMinions.size(); r++) {}
            	//create an if statement that determines if ind-1 is greater than ind, then swaps if true
        	
            	temp = this.theMinions.get(ind);
                this.theMinions.set(ind, this.theMinions.get(ind-1));
                this.theMinions.set(ind-1, temp);
                i--;
        	}
            //Possibility 1 (part 2)
            //if(elst)
            //{temp = this.theMinions.get(ind);
            //this.theMinions.set(ind, this.theMinions.get(ind-1));
            //this.theMinions.set(ind-1, temp);}
        	}}
}