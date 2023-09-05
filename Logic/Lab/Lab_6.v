module SR_Latch (
  input S, // Set input
  input R, // Reset input
  output Q, // Output
  output ~Q // Inverted Output
);

  // SR Latch logic using NOR gates
  wire nS, nR;
  assign nS = ~S; // Invert S input
  assign nR = ~R; // Invert R input

  // Q and ~Q outputs
  assign Q = ~(nR & Q);
  assign ~Q = ~(nS & ~Q);

endmodule
