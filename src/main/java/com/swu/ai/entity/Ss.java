package com.swu.ai.entity;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/3 21:20
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public class Ss {
    private Long a = 2L;
    private Long b = 0L;
    private Long c = 3L;

    public Long getA() {
        if(this.a==null){
            this.a = this.b + this.c;
        }
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }

    public Long getB() {
        return b;
    }

    public void setB(Long b) {
        this.b = b;
    }

    public Long getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Ss{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public void setC(Long c) {
        this.c = c;
    }
}


