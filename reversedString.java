
public Class reversedString{
  public String reverseString(String s){
    StringBuilder reversed = new StringBuilder();
    reversed = null;

    if(s.length < 2){ return reversed.append(s);}

    for(int i = s.length; i > 1; i--){
      reversed.append(s.charAt(i));
    }

    return s;
  }
}
