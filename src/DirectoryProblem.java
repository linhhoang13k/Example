package com.iub.coding.practice.CodeName47;

import java.util.Stack;
import java.util.regex.Pattern;

public class DirectoryProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int globalSpaceCount = 0, localSpaceCount = 0;
		int totalCount = 0, localCount = 0;

		/*
		 * String input = "dir1\n" + " dir11\n" + " dir12\n" + "  picture.txt\n"
		 * + "  picture.txt\n" + "   dir 121\n" + "    file1.jpeg\n" +
		 * "    file1.jpeg\n" + "    dir1211\n" + "     test.png\n" + "dir2\n" +
		 * " file2.txt\n" + " file2.txt\n" + "xyz.jpeg";
		 */
		String input = "dir1\ndir2\n dir21\n  im211.jpg\n dir22\n  dir222\n  im221.jpg\n  dir223\n  im23.jpg\nim23.jpg";
		// String input = "dir1\ndir2\n dir21\n im211.jpg\n dir22\n dir222\n
		// im221.jpg\n dir223\n im23.jpg\nim23.jpg";⁠⁠⁠⁠

		System.out.println("Letter Count : " + solution(input));

	}

	public static int getDirectoryPathCount(String input) {

		int globalSpaceCount = 0, localSpaceCount = 0;
		int totalCount = 0, localCount = 0;

		if (null == input)
			return 0;

		int inputLength = input.length();

		boolean isImageFile = false;

		for (int i = inputLength - 1; i >= -1; i--) {

			if (i >= 0)
				System.out.print(input.charAt(i));
			if (i == -1 || input.charAt(i) == '\n') {

				// Check if file or directory

				if (isImageFile) {
					globalSpaceCount = localSpaceCount;
					isImageFile = false;
				}

				if (globalSpaceCount > localSpaceCount) {
					totalCount += localCount + 1;
					globalSpaceCount--;
				}

				localCount = 0;
				localSpaceCount = 0;

			} else if (input.charAt(i) == '.') {

				// Check extension
				if (checkImageExtension(input, i, inputLength))
					isImageFile = true;

			} else if (input.charAt(i) == 32 || input.charAt(i) == 160) {
				localSpaceCount++;
			} else {

				localCount++;
				localCount += localSpaceCount;
				localSpaceCount = 0;
			}
		}

		return totalCount;
	}

	public static int getDirectoryPathCountImproved(String input) {

		int globalSpaceCount = 0, localSpaceCount = 0, prevSpaceCount = -1;
		int totalAbsPathCount = 0, localDirPathCount = 0;
		int currentDirectoryCount = 0;
		Stack<Integer> directoryLengthTrace = new Stack<Integer>();

		if (null == input)
			return 0;

		int inputLength = input.length();

		boolean isImageFile = false, isDir = true, isFileNamePart = false;

		for (int i = 0; i <= inputLength; i++) {

			if (i < inputLength)
				System.out.print(input.charAt(i));

			if (i == inputLength || input.charAt(i) == '\n') {

				// Check if file or directory

				if (isDir) {

					/*
					 * New directory
					 */
					if (localSpaceCount > prevSpaceCount) {

						/*
						 * Increase directory size & push size count to stack
						 */

						currentDirectoryCount += localDirPathCount + 1;

						directoryLengthTrace.push(localDirPathCount + 1);

						prevSpaceCount = localSpaceCount;

						globalSpaceCount = localSpaceCount;
					} else {

						for (int j = 0; j <= prevSpaceCount - localSpaceCount; j++) {

							if (!directoryLengthTrace.isEmpty())
								currentDirectoryCount -= directoryLengthTrace.pop();

							globalSpaceCount -= j;
						}

						currentDirectoryCount += localDirPathCount + 1;
						directoryLengthTrace.push(localDirPathCount + 1);
						prevSpaceCount = localSpaceCount;
					}

				} else if (isImageFile) {

					if (localSpaceCount == 0)
						totalAbsPathCount++;
					else
						totalAbsPathCount += currentDirectoryCount;
					isImageFile = false;
				}

				localDirPathCount = 0;
				localSpaceCount = 0;
				isFileNamePart = false;
				isDir = true;

			} else if (input.charAt(i) == '.') {

				isDir = false;
				// Check extension
				if (checkImageExtension(input, i, inputLength)) {
					isImageFile = true;
					i += 3;
				}

			} else if (!isFileNamePart && input.charAt(i) == 32 || input.charAt(i) == 160) {
				localSpaceCount++;
			} else {

				localDirPathCount++;
				isFileNamePart = true;

			}
		}

		System.out.println("\n\n*******Answer *****");

		return totalAbsPathCount;
	}

	public static boolean checkImageExtension(String source, int dotIndex, int len) {

		String pattern = "((\\.(?i)(jpg|jpeg|png|gif|bmp))$)";

		if ((dotIndex + 5) <= len) {

			return Pattern.compile(pattern).matcher(source.substring(dotIndex, dotIndex + 5)).find();
		} else if ((dotIndex + 4) <= len) {
			return Pattern.compile(pattern).matcher(source.substring(dotIndex, dotIndex + 4)).find();

		}

		return false;
	}

	public static int solution(String S) {
		// write your code in Java SE 8
		/*
		 * Variables for Space count
		 */
		int globalSpaceCount = 0, localSpaceCount = 0, prevSpaceCount = 0;

		/*
		 * Variables for path count
		 */

		int longestAbsPath = 0, dirPathCounter = 0, currentDirectoryPathCount = 0;
		Stack<Integer> diretoryLengthTrace = new Stack<Integer>();

		if (null == S)
			return 0;

		int inputLength = S.length();

		boolean isImageFile = false, isDir = true, isFileNamePart = false;

		for (int i = 0; i <= inputLength; i++) {

			if (i < inputLength)
				System.out.print(S.charAt(i));

			if (i == inputLength || S.charAt(i) == '\n') {

				// Check if file or directory

				if (isDir) {

					/*
					 * New directory
					 */
					if (localSpaceCount > prevSpaceCount) {

						/*
						 * Increase directory size & push size count to stack
						 */

						currentDirectoryPathCount += dirPathCounter + 1;

						diretoryLengthTrace.push(dirPathCounter + 1);

						prevSpaceCount = localSpaceCount;

						globalSpaceCount = localSpaceCount;
					} else {

						for (int j = 0; j <= prevSpaceCount - localSpaceCount; j++) {

							if (!diretoryLengthTrace.isEmpty())
								currentDirectoryPathCount -= diretoryLengthTrace.pop();

							globalSpaceCount -= j;
						}

						currentDirectoryPathCount += dirPathCounter + 1;
						diretoryLengthTrace.push(dirPathCounter + 1);
						prevSpaceCount = localSpaceCount;
					}

				} else if (isImageFile) {

					if (localSpaceCount == 0) {

						if (longestAbsPath < 1)
							longestAbsPath = 1;
					} else if (longestAbsPath < currentDirectoryPathCount) {
						longestAbsPath = currentDirectoryPathCount;
					}
					isImageFile = false;
				}

				dirPathCounter = 0;
				localSpaceCount = 0;
				isFileNamePart = false;
				isDir = true;

			} else if (S.charAt(i) == '.') {

				isDir = false;
				// Check extension
				if (checkImageExtension(S, i, inputLength)) {
					isImageFile = true;
					i += 3;
				}

			} else if (!isFileNamePart && S.charAt(i) == 32 || S.charAt(i) == 160) {
				localSpaceCount++;
			} else {

				dirPathCounter++;
				isFileNamePart = true;

			}
		}

		System.out.println("\n\n*******Answer *****");

		return longestAbsPath;

	}

	public static int solution2(String S) {
		Stack<String> stack = new Stack<String>();
		int max = 0, directorySpace = 0;
		String string = "";
		int path = 0;
		int currentLineSpace;
		String[] str = S.split("\n");
		for (int i = 0; i < str.length; i++) {
			String line = str[i];
			System.out.println(line);
			currentLineSpace = line.length() - line.trim().length();
			if (line.contains(".jpeg") || line.contains(".png") || line.contains(".gif")) {
				if (directorySpace == currentLineSpace && directorySpace != 0 && !stack.isEmpty()) {
					String line2 = stack.pop();
					path = path - line2.trim().length() - 1;
					directorySpace = directorySpace - 1;
				}
				if (directorySpace > currentLineSpace) {
					while (directorySpace > currentLineSpace && !stack.isEmpty()) {
						String line2 = stack.pop();
						path = path - line2.trim().length() - 1;
						directorySpace = line2.length() - line2.trim().length();
					}
				}
				if (path > max)
					max = path;
				if (path == 0) {
					max = 1;
				}
			} else if (line.contains(".")) {
				continue;
			} else if (directorySpace < currentLineSpace) {
				stack.push(line);
				directorySpace = currentLineSpace;
				path = path + line.trim().length() + 1;
			} else if (directorySpace == currentLineSpace) {

				if (directorySpace == currentLineSpace && !stack.isEmpty()) {
					String line2 = stack.pop();
					path = path - line2.trim().length() - 1;
					directorySpace = line2.length() - line2.trim().length();
				}
				stack.push(line);
				directorySpace = currentLineSpace;
				path = path + line.trim().length() + 1;

			}

			else if (directorySpace >= currentLineSpace) {

				while (directorySpace > currentLineSpace && !stack.isEmpty()) {
					String line2 = stack.pop();
					path = path - line2.trim().length() - 1;
					directorySpace = line2.length() - line2.trim().length();
				}
				stack.push(line);
				directorySpace = currentLineSpace;
				path = path + line.trim().length() + 1;

			} else {
				for (int i1 = 0; i1 < stack.size(); i1++) {
					String line2 = stack.pop();
					path = path - line2.trim().length() - 1;
					if (directorySpace <= line2.length() - line2.trim().length()) {
						break;
					}

				}
			}

		}
		return max;
	}
}
