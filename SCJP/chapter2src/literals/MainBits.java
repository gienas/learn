package literals;

public class MainBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//System.out.println(getBits(1));
		
		
		//System.out.println( i);
		//System.out.println(getBits(i));
		
		
		//short lvShort  = 32000;
		float lvFloat = 2.2f;
		char lvChar = '\"';
		byte lvByte = 7;
		//System.out.println(lvChar);
		
		
		short lvShort = (short)0x7FFF;
		System.out.println(lvShort);
		System.out.println(getBitsShort(lvShort));
		
		
	}

	  public static String getBits( int value )
      {
      int displayMask = 1 << 31;
      StringBuffer buf = new StringBuffer( 35 );
     
      for ( int c = 1; c <= 32; c++ ) 
          {
          buf.append( ( value & displayMask ) == 0 ? '0' : '1' );
          value <<= 1;
         
          if ( c % 8 == 0 )
          buf.append( ' ' );
      }
     
      return buf.toString();
  }
	  
	  public static String getBitsShort( short value )
      {
      int displayMask = 1 << 15;
      StringBuffer buf = new StringBuffer( 18 );
     
      for ( int c = 1; c <= 16; c++ ) 
          {
          buf.append( ( value & displayMask ) == 0 ? '0' : '1' );
          value <<= 1;
         
          if ( c % 8 == 0 )
          buf.append( ' ' );
      }
     
      return buf.toString();
  }
}
