module T_FF(q, t, clk, reset);
  output q;
  input t, clk, reset;
  reg q;
  
  always @(negedge clk or posedge reset)
    if (reset)
      q <= 1'b0;
    else
      q <= (t & ~q) | (~t & q);
endmodule
