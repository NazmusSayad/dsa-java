import java.util.Stack;

public class BracketParser {
  public String parse(String input) {
    var inputStack = new Stack<Character>();
    var output = new StringBuffer();

    for (var ch : input.toCharArray()) {
      if (ch == '(') {
        inputStack.push(ch);
      } else if (ch == ')') {
        if (inputStack.isEmpty()) {
          output.append(")");
        } else {
          inputStack.pop();
        }
      }
    }

    System.out.println(inputStack);
    return output.toString();
  }
}
