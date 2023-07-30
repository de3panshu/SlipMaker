/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robo;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Robo {
	// Our custom sleep method
	public static void sleep(long ms) {
		try {Thread.sleep(ms);} catch (Exception ignored) {}
	}

	public static void main(String[] args) throws Exception {
		// Open Notepad
//		Runtime.getRuntime().exec("notepad.exe");
//		// Wait for 2 seconds
		sleep(2000);
		// Create instance of Robot class
		Robot robot = new Robot();
		// The String to type
		String str = "long fromIndia = (X - 1) / 2;\n" +
"    long fromSrilanka;\n" +
"    \n" +
"    if (N % 2 == 0) \n" +
"        fromSrilanka = (N - X + 1) / 2;\n" +
"     else \n" +
"        if (X == N) \n" +
"            fromSrilanka = (N - X) / 2;\n" +
"         else \n" +
"            fromSrilanka = (N - X) / 2 + 1;\n" +
"        \n" +
"    \n" +
"    \n" +
"    return Math.min(fromIndia, fromSrilanka);";
		// Press keys using robot
		// A gap of 200ms is added between each key press
		for (int i = 0; i < str.length(); i++) {
			// Check if the current character is a capital letter
                        switch(str.charAt(i))
                        {
                            case '*':robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
				robot.keyPress(KeyEvent.VK_8);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '\'':
                                //robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_QUOTE);
				// Release shift key
				//robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '_':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_MINUS);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case ':':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                System.out.println(KeyEvent.getExtendedKeyCodeForChar('{'));
				robot.keyPress(KeyEvent.VK_SEMICOLON);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;
                            case '|':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                System.out.println(KeyEvent.getExtendedKeyCodeForChar('{'));
				robot.keyPress(KeyEvent.VK_BACK_SLASH);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;
                            case '?':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                System.out.println(KeyEvent.getExtendedKeyCodeForChar('{'));
				robot.keyPress(KeyEvent.VK_SLASH);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;
                                
                            case '}':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '(':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_9);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case ')':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_0);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '<':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_COMMA);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '"':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_QUOTE);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '\\':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_BACK_SLASH);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '>':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_PERIOD);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '+':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_EQUALS);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '`':
//                                robot.keyPress(KeyEvent.VK_SHIFT);
//				// Press the current character
                                robot.keyPress(KeyEvent.VK_BACK_QUOTE);
//				// Release shift key
//				robot.keyRelease(KeyEvent.VK_SHIFT);
//                                continue;    
                            
                            case '~':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_BACK_QUOTE);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                            case '!':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_1);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;            
                            case '@':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_2);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '#':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_3);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '$':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_4);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '%':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_5);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '^':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_6);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;        
                            case '&':
                                robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
                                robot.keyPress(KeyEvent.VK_7);
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
                                continue;    
                                
                                
                                
                        }
			if (Character.isUpperCase(str.charAt(i))) {
				// Press shift key
				robot.keyPress(KeyEvent.VK_SHIFT);
				// Press the current character
				robot.keyPress(Character.toUpperCase(str.charAt(i)));
				// Release shift key
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
			// else display the character as it is
			else robot.keyPress(Character.toUpperCase(str.charAt(i)));
			// wait for 200ms
			sleep(200);
		}
	}
}

