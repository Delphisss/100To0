module BinaryGrayCounter_TB;
  reg clk, reset, x;
  wire q2, q1;

  BinaryGrayCounter counter (
    .q2(q2),
    .q1(q1),
    .clk(clk),
    .reset(reset),
    .x(x)
  );

  // Clock Generation
  always begin
    #5 clk = ~clk;
  end

  // Reset Generation
  initial begin
    clk = 0;
    reset = 0;
    x = 0;
    #10 reset = 1;
    #10 reset = 0;
  end

  // Stimulus
  initial begin
    $monitor("Time=%t, Q2Q1=%b, X=%b", $time, {q2, q1}, x);
    #5 x = 1;
    #50 $finish;
  end
endmodule

Time=0, Q2Q1=00, X=00
Time=5, Q2Q1=00, X=01
Time=10, Q2Q1=01, X=01
Time=15, Q2Q1=10, X=01
Time=20, Q2Q1=11, X=01
Time=25, Q2Q1=00, X=01
Time=30, Q2Q1=01, X=01
Time=35, Q2Q1=10, X=01
Time=40, Q2Q1=11, X=01
Time=45, Q2Q1=00, X=01
Time=50, Q2Q1=01, X=01
Time=55, Q2Q1=10, X=01
Time=60, Q2Q1=11, X=01
Time=65, Q2Q1=00, X=01
Time=70, Q2Q1=01, X=01
Time=75, Q2Q1


