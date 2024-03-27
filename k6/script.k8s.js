import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 2,
  duration: '10s',
};

export default function () {
  const url = 'http://127.0.0.1/api/shortest-path';
  const payload = JSON.stringify({
    "grid": [
      [1, 1, 1, 1, 1],
      [0, 0, 1, 0, 1],
      [1, 1, 1, 1, 1],
      [1, 0, 0, 0, 1],
      [1, 1, 1, 1, 1]
    ]
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const res = http.post(url, payload, params);
  check(res, {
    'is status 200': (r) => r.status === 200,
  });
}