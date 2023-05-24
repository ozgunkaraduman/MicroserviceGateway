package com.migros.ucg.user_management.utility;

import javax.swing.*;
import java.util.List;

public final class Util
{
    private static final int TCKN_HANE = 11;

    private Util() {}

    // kaynak: Ahmet Bütün
    public static boolean isValidTCKN(String TCKN)
    {
        if (null!=TCKN && TCKN.matches("^([1-9]{1}[0-9]{10})$"))
        {
            return isValidTCKN(Long.valueOf(TCKN));
        }

        return false;
    }

    private static boolean isValidTCKN(Long TCKN)
    {
        String tmp = TCKN.toString();

        if (tmp.length() == TCKN_HANE)
        {
            int totalOdd = 0;

            int totalEven = 0;

            for (int i = 0; i < 9; i++) {
                int val = Integer.valueOf(tmp.substring(i, i + 1));

                if (i % 2 == 0) {
                    totalOdd += val;
                } else {
                    totalEven += val;
                }
            }

            int total = totalOdd + totalEven
                    + Integer.valueOf(tmp.substring(9, 10));

            int lastDigit = total % 10;

            if (tmp.substring(10).equals(String.valueOf(lastDigit)))
            {
                int check = (totalOdd * 7 - totalEven) % 10;

                if (tmp.substring(9, 10).equals(String.valueOf(check)))
                {
                    return true;
                }
            }
        }

        return false;
    }



    public static<E> String arrangeList(List<E> list)
    {
        return list.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    public static void showGeneralExceptionInfo(Exception e)
    {
        System.err.println( createGeneralExceptionInfo(e) );
    }

    public static String createGeneralExceptionInfo(Exception e)
    {
        return e.getClass().getSimpleName() + " has been occured. Exception message: " + e.getMessage();
    }

    public static <E> void showListElements(List<E> list)
    {
        System.out.println("\nList elements:");

        for (E entity : list)
        {
            System.out.println(entity);
        }
    }

    public static <E> void showArrayElements(E[] array)
    {
        System.out.println("\nArray elements:");

        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

    public static void showQuestionMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Question Message", JOptionPane.QUESTION_MESSAGE);
    }

    public static void showErrorMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarningMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Warning Message", JOptionPane.WARNING_MESSAGE);
    }

    public static void showInfoMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Info Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
