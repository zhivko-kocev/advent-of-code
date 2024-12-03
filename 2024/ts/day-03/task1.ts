let text = "";

for await (const line of console) {
  if (line.length == 0) break;

  text += line;
}

const matches = text.matchAll(/mul\((\d{1,3}),(\d{1,3})\)/g);

let sum = 0;
for (const match of matches) {
  const num1 = parseInt(match[1]);
  const num2 = parseInt(match[2]);
  sum += num1 * num2;
}

console.log(sum);
