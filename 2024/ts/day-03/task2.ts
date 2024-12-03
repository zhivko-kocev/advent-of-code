let text = "";

for await (const line of console) {
  if (line.length == 0) break;

  text += line;
}

const matches = text.matchAll(/mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)/g);

let sum = 0;
let calculate = true;
for (const match of matches) {
  if (match[0] == "do()") {
    calculate = true;
    continue;
  }

  if (match[0] == "don't()") {
    calculate = false;
    continue;
  }

  if (calculate) {
    const num1 = parseInt(match[1]);
    const num2 = parseInt(match[2]);
    sum += num1 * num2;
  }
}

console.log(sum);
