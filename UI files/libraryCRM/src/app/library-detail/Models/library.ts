import { Book } from "./book";
import { Member } from "./member";

export interface Library{
  id: string;
  name: string;
  members: Member[];
  books: Book[];
}
