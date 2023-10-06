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
    q[WIDTH-1:0] <= {1'b0, q[WIDTH-1:1] ^ q[WIDTH-1:0]}; // XOR operation for Gray code
  end else begin
    // Binary counter mode
    q[WIDTH-1:0] <= q[WIDTH-1:0] + 1'b1;
  end
end

endmodule
