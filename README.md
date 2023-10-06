module binary_gray_counter #(parameter WIDTH = 2) (
  output [WIDTH-1:0] q,
  input clk, reset, X
);

reg [WIDTH-1:0] q;

always @(posedge clk or posedge reset) begin
  if (reset) begin
    q <= {WIDTH{1'b0}};
  end else if (X) begin
    // Gray counter mode
    q[WIDTH-1:0] <= q[WIDTH-1] ? {1'b0, q[WIDTH-2:0]} : {1'b1, ~q[WIDTH-2:0]};
  end else begin
    // Binary counter mode
    q[WIDTH-1:0] <= q[WIDTH-1:0] + 1'b1;
  end
end

endmodule



module stimulus;
reg clk, reset;
reg X;
initial clk = 1'b0;
always #5 clk = ~clk;
initial begin
  reset = 1'b0;
  X = 1'b0;
  #30 X = 1'b1;
  #50 X = 1'b0;
  #60 reset = 1'b1;
  #70 $finish;
end
endmodule

