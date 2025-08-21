let currentInput = "";
let previousInput = "";
let operation = null;

function appendNumber(number) {
  if (number === "." && currentInput.includes(".")) return;
  currentInput += number;
  updateDisplay();
}

function chooseOperation(op) {
  if (currentInput === "") return;
  if (previousInput !== "") {
    calculate();
  }
  operation = op;
  previousInput = currentInput;
  currentInput = "";
}

function calculateResult() {
  if (previousInput === "" || currentInput === "" || operation === null) return;
  calculate();
  operation = null;
}

function calculate() {
  let result;
  const prev = parseFloat(previousInput);
  const curr = parseFloat(currentInput);

  if (isNaN(prev) || isNaN(curr)) return;

  switch (operation) {
    case '+':
      result = prev + curr;
      break;
    case '-':
      result = prev - curr;
      break;
    case '*':
      result = prev * curr;
      break;
    case '/':
      if (curr === 0) {
        alert("Error: Division by zero!");
        clearDisplay();
        return;
      }
      result = prev / curr;
      break;
    default:
      return;
  }

  currentInput = result.toString();
  previousInput = "";
  updateDisplay();
}

function clearDisplay() {
  currentInput = "";
  previousInput = "";
  operation = null;
  updateDisplay();
}

function updateDisplay() {
  document.getElementById("display").value = currentInput;
}
