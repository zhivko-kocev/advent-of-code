const first: number[] = [];
const second: number[] = [];

for await (const line of console) {
  if (line.length == 0) break;

  const pair = line.split(/\s+/);

  first.push(parseInt(pair[0]));
  second.push(parseInt(pair[1]));
}

first.sort((a, b) => a - b);
second.sort((a, b) => a - b);

let sum = 0;
first.forEach((num1, index) => {
  sum += Math.abs(num1 - second[index]);
});

console.log(sum);
