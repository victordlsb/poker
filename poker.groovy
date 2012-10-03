boolean rank_ok = false;
boolean suit_ok = false;
boolean straight_flush = true;
boolean poker = true;
boolean full_house =true;
boolean flush = true;
boolean straight = true;
boolean three_kind = true;
boolean two_pairs = true;
boolean pair = true;


String src;
int[][] card = new int[5][2];
int i=0;

for(i=0;i<5;i++){
	while(!rank_ok){
		print "Insert the rank of card " + (i+1) + ": ";
		src = System.console().readLine();
		if (src == "J" || src == "j"){
			card[i][0] = 11;
			rank_ok = true;
		}else if (src == "Q" || src == "q"){
			card[i][0] = 12;
			rank_ok = true;
		}else if (src == "K" || src == "k"){
			card[i][0] = 13;
			rank_ok = true;
		}else if (src == "A" || src == "a"){
			card[i][0] = 14;
			rank_ok = true;						
		}else if (src == "2" || src == "3" || src == "4" || src == "5" || src == "6" || src == "7" || src == "8" || src == "9" || src == "10"){
			card[i][0] = Integer.parseInt(src);
			rank_ok = true;
		}else{
			println("The rank of the card is wrong, please introduce it again (it should be a number between 2 to 10 or J Q K A).");
		}
	}


	//Values assigned for the suits: spades = 1, hearts = 2, diamonds = 3, clubs = 4
	while(!suit_ok){
		print "Insert the suit  " + (i+1) + ": ";
		src = System.console().readLine();
		src = src.toLowerCase(); 							// it doesn't matter whether the string has caps or not
		if (src == "spades"){
			card[i][1] = 1;
			suit_ok = true;
		} else if ( src == "hearts"){
			card[i][1] = 2;
			suit_ok = true;
		} else if ( src == "diamonds"){
			card[i][1] = 3;
			suit_ok = true;
		} else if ( src == "clubs"){
			card[i][1] = 4;
			suit_ok = true;
		} else {
			println("The suit of the card is wrong, please introduce it again. It should be spades, hearts, diamonds or clubs");
		}
	}
	rank_ok = false;
	suit_ok = false;
}




for (i=0;i<5;i++){
	for (int j=(i+1);j<5;j++){
		if(card[i][0]>card[j][0]){
			int temp = card[i][0];
			card[i][0]= card[j][0];
			card[j][0]=temp;
		}else if(card[i][0]==card[j][0]){
			straight=false;
			straight_flush=false;
		}		
	}
}

// checking if  they all are from the same suit;
for(i=0;i<4;i++){
	if (card[i][1]!=card[i+1][1]){
		flush = false;
		straight_flush=false;
		break;
	}
}


// checking if it is straight
for(i=0;i<4;i++){
	if (card[i][0]+1!=card[i+1][0]){
		straight=false;
		straight_flush=false;
	}
}


// Print the hand

if (straight_flush){
	println ("You got a straight flush!");
//} else if (poker){
//	println ("You got a poker!");
//} else if (full_house){
//	println ("You have a full_house!");
} else if (flush) {
	println ("You have a flush");
} else if (straight){
	println ("You got a straight!");
//} else if (three_kind){
//	println ("You got three of a kind");
//} else if (two_pairs){
//	println ("You have two pairs");
//} else if (pair){
//	println ("You have a pair ");
} else {
	println ("You got absolutely nothing...");
}



		

/*

for(i=0;i<5;i++){
	println (card[i][0]);
}
	

*/