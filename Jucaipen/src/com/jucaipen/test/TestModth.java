package com.jucaipen.test;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class TestModth extends JFrame {
	private JButton btn1 = new JButton("Button 1");
	private JButton btn2 = new JButton("Button 2");
	private Robot robot;

	public TestModth() {
		setLayout(new GridLayout(0, 1));
		add(btn1);
		add(btn2);

		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1)
					System.out.println(btn1.getText() + "���������");
				if (event.getButton() == MouseEvent.BUTTON3)
					System.out.println(btn1.getText() + "����Ҽ����");
			}
		});
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getButton() == MouseEvent.BUTTON1)
					System.out.println(btn2.getText() + "���������");
				if (event.getButton() == MouseEvent.BUTTON3)
					System.out.println(btn2.getText() + "����Ҽ����");
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent event) {
			}
		});
	}

	public void simulationClick() throws AWTException {
		// ģ�����������
		Point p1 = btn1.getLocation();
		Point p2 = btn2.getLocation();
		System.out.println(p1.x + "," + p1.y);
		System.out.println(p2.x + "," + p2.y);
		Point p = MouseInfo.getPointerInfo().getLocation();
		int x = p.x;
		int y = p.y;
		robot = new Robot();
		System.out.println(x + "," + y);
		robot.mouseMove(p1.x + 10, p2.y + 10);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mouseMove(x, y);
	}

	/*
	 * public static void main(String[] args) { String ss =
	 * "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.baidu.com"
	 * ; try { Process p = Runtime.getRuntime().exec(ss); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(190, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(03ew
	 * Runnable() { public void run() { TestModth frame = new TestModth();
	 * frame.pack(); frame.setVisible(true);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); try {
	 * frame.simulationClick(); } catch (AWTException e) { e.printStackTrace();03
	 * } } }); }
	 */
}
