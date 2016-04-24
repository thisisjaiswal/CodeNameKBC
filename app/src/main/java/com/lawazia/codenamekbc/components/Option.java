package com.lawazia.codenamekbc.components;

public class Option
{
    public char Pos;
    public String Text;

    @Override
    public String toString() {
        return String.format(Pos + " | " + Text);
    }
}
